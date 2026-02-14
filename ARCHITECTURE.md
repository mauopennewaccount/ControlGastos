# Arquitectura de la Aplicación Control de Gastos

## Diagrama de Capas

```
┌─────────────────────────────────────────────────────────────┐
│                        CAPA DE UI                            │
│  ┌─────────────────────────────────────────────────────┐   │
│  │              MainActivity                             │   │
│  │          (Navigation Drawer)                          │   │
│  └─────────────────────────────────────────────────────┘   │
│                          │                                   │
│  ┌────────────┬─────────┴───────┬────────────┬──────────┐  │
│  │            │                  │            │          │  │
│  │  Dashboard │    Income       │  Expense   │ Category │  │
│  │  Fragment  │    Fragment     │  Fragment  │ Fragment │  │
│  │            │                  │            │          │  │
│  │  ┌─────┐   │    ┌─────┐      │  ┌─────┐  │ ┌─────┐  │  │
│  │  │Cards│   │    │Form │      │  │Form │  │ │List │  │  │
│  │  └─────┘   │    └─────┘      │  └─────┘  │ └─────┘  │  │
│  │            │                  │            │          │  │
│  └────────────┴──────────────────┴────────────┴──────────┘  │
│                                                               │
│  ┌────────────┬────────────────────────────────────────┐    │
│  │            │                                         │    │
│  │  Period    │           Reports                      │    │
│  │  Fragment  │           Fragment                     │    │
│  │            │                                         │    │
│  │  ┌─────┐   │    ┌──────────┬───────────┐          │    │
│  │  │List │   │    │PDF Export│Excel Export│          │    │
│  │  │Clone│   │    └──────────┴───────────┘          │    │
│  │  └─────┘   │                                         │    │
│  │            │                                         │    │
│  └────────────┴─────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│                  CAPA DE LÓGICA DE NEGOCIO                   │
│  ┌─────────────────────────────────────────────────────┐   │
│  │                ExpenseRepository                      │   │
│  │  ┌────────────────────────────────────────────┐     │   │
│  │  │ • getAllIncomes()                          │     │   │
│  │  │ • getAllExpenses()                         │     │   │
│  │  │ • getExpensesByPeriod()                    │     │   │
│  │  │ • getTotalIncomeByPeriod()                 │     │   │
│  │  │ • getTotalExpenseByPeriod()                │     │   │
│  │  │ • clonePeriod()                            │     │   │
│  │  └────────────────────────────────────────────┘     │   │
│  └─────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│                    CAPA DE DATOS (Room)                      │
│  ┌──────────┬──────────┬─────────┬────────────┬─────────┐  │
│  │          │          │         │            │         │  │
│  │ Category │Subcategory│ Period │  Income    │ Expense │  │
│  │   DAO    │    DAO   │   DAO  │    DAO     │   DAO   │  │
│  │          │          │         │            │         │  │
│  └──────────┴──────────┴─────────┴────────────┴─────────┘  │
│                            │                                 │
│  ┌─────────────────────────▼──────────────────────────┐    │
│  │              AppDatabase                            │    │
│  │           (Room Database)                           │    │
│  └─────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│                   BASE DE DATOS SQLite                       │
│  ┌─────────────────────────────────────────────────────┐   │
│  │         control_gastos_database.db                   │   │
│  │                                                       │   │
│  │  Tablas:                                             │   │
│  │  • categories                                        │   │
│  │  • subcategories  (FK → categories)                 │   │
│  │  • periods                                           │   │
│  │  • incomes        (FK → periods)                    │   │
│  │  • expenses       (FK → categories, subcategories,  │   │
│  │                         periods)                     │   │
│  └─────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────┘
```

## Flujo de Datos

### 1. Registro de Gasto
```
Usuario
  │
  ▼
[Expense Fragment]
  │ - Selecciona categoría
  │ - Ingresa monto
  │ - Selecciona estado
  ▼
[Repository]
  │ - insertExpense()
  ▼
[ExpenseDao]
  │ - insert()
  ▼
[Room Database]
  │
  ▼
[SQLite]
```

### 2. Visualización del Dashboard
```
[Dashboard Fragment]
  │
  ▼
[Repository]
  │ - getTotalIncomeByPeriod()
  │ - getTotalExpenseByPeriod()
  ▼
[DAOs] → [Room] → [SQLite]
  │
  │ (LiveData)
  ▼
[Dashboard Fragment]
  │ - Actualiza UI
  ▼
Usuario ve balance actualizado
```

### 3. Clonado de Período
```
Usuario selecciona período
  │
  ▼
[Period Fragment]
  │ - Solicita clonar
  ▼
[Repository.clonePeriod()]
  │ - Crea nuevo período
  │ - Obtiene ingresos del período original
  │ - Obtiene gastos del período original
  │ - Clona todos los registros
  ▼
[DAOs] → Múltiples inserts
  │
  ▼
[SQLite] - Nuevo período creado
```

## Relaciones de Base de Datos

```
┌──────────────┐
│  categories  │
│──────────────│
│ id (PK)      │◄─────┐
│ name         │      │
│ createdAt    │      │ FK
└──────────────┘      │
                      │
                      │
┌──────────────┐      │
│subcategories │      │
│──────────────│      │
│ id (PK)      │      │
│ name         │      │
│ categoryId───┼──────┘
│ createdAt    │
└──────────────┘
       │ FK
       │
       │
┌──────────────┐      
│   expenses   │
│──────────────│
│ id (PK)      │
│ categoryId───┼──────┐
│ subcategoryId├──────┤ FK
│ description  │      │
│ amount       │      │
│ status       │      │
│ date         │      │
│ periodId─────┼────┐ │
│ createdAt    │    │ │
└──────────────┘    │ │
                    │ │
┌──────────────┐    │ │
│   periods    │    │ │
│──────────────│    │ │
│ id (PK)      │◄───┼─┘
│ name         │    │
│ startDate    │    │
│ endDate      │    │
│ createdAt    │    │
└──────────────┘    │
       ▲            │
       │ FK         │
       │            │
┌──────────────┐    │
│   incomes    │    │
│──────────────│    │
│ id (PK)      │    │
│ type         │    │
│ amount       │    │
│ description  │    │
│ date         │    │
│ periodId─────┼────┘
│ createdAt    │
└──────────────┘
```

## Componentes Clave

### 1. Entities (Entidades de Datos)
- **Category**: Categorías principales
- **Subcategory**: Subcategorías con relación a Category
- **Period**: Períodos de tiempo
- **Income**: Ingresos con enum IncomeType
- **Expense**: Gastos con enum ExpenseStatus

### 2. DAOs (Data Access Objects)
Cada DAO proporciona:
- `insert()` / `insertAll()`
- `update()`
- `delete()`
- `getAll()` → LiveData
- Consultas específicas (por período, por estado, etc.)
- Agregaciones (SUM, COUNT)

### 3. Repository
**ExpenseRepository** centraliza:
- Acceso a todos los DAOs
- Lógica de negocio (ej: clonePeriod)
- Coordinación entre tablas
- Capa de abstracción para la UI

### 4. Fragments (Pantallas)
- **DashboardFragment**: Balance y totales
- **IncomeFragment**: Gestión de ingresos
- **ExpenseFragment**: Gestión de gastos
- **CategoryFragment**: Categorías y subcategorías
- **PeriodFragment**: Períodos y clonado
- **ReportsFragment**: Exportación PDF/Excel

## Tecnologías por Capa

### UI Layer
- Material Design Components
- ViewBinding
- DrawerLayout
- CardView
- RecyclerView (preparado)

### Business Logic
- Repository Pattern
- LiveData
- Coroutines
- ViewModels (preparado)

### Data Layer
- Room ORM
- SQLite
- Type Converters
- Foreign Keys
- Cascade Deletes

### Export
- iText 7 (PDF)
- Apache POI (Excel)

## Patrones de Diseño Utilizados

1. **Repository Pattern**: Abstracción de fuentes de datos
2. **DAO Pattern**: Separación de lógica de acceso a datos
3. **Observer Pattern**: LiveData para actualizaciones reactivas
4. **Singleton Pattern**: AppDatabase instance
5. **Builder Pattern**: Room database builder

## Configuración de Permisos

```xml
<!-- Internet (para futuras funcionalidades) -->
<uses-permission android:name="android.permission.INTERNET" />

<!-- Almacenamiento (para exportar reportes) -->
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" 
    android:maxSdkVersion="28" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"
    android:maxSdkVersion="32" />
```

## Resumen

Esta arquitectura proporciona:
- ✅ Separación clara de responsabilidades
- ✅ Código mantenible y testeable
- ✅ Escalabilidad para nuevas features
- ✅ Seguimiento de mejores prácticas Android
- ✅ Base sólida para desarrollo futuro
