# Control de Gastos - Aplicación Android

## Descripción General

Aplicación Android completa para la gestión y control de gastos personales, desarrollada en Kotlin con arquitectura moderna y siguientes las mejores prácticas de Android.

## Características Principales

### 1. Gestión de Ingresos
- Registro de ingresos clasificados por tipo:
  - Tarjeta
  - Billetera  
  - Monedas
- Incluye monto, descripción y fecha
- Asociados a períodos específicos

### 2. Gestión de Gastos
- Registro completo de gastos con:
  - Categoría y subcategoría
  - Descripción principal
  - Descripción adicional
  - Monto
  - Estado (Pendiente, Pagado, Inactivo)
  - Fecha
- Filtrado por estado y período

### 3. Sistema de Categorías
- Gestión de categorías principales
- Subcategorías asociadas a cada categoría
- Relación padre-hijo con eliminación en cascada

### 4. Gestión de Períodos
- Creación de períodos con rangos de fecha (inicio y fin)
- Todos los registros se asocian a un período
- **Funcionalidad de clonado**: Permite duplicar períodos completos con todos sus registros de ingresos y gastos

### 5. Generación de Reportes
- Exportación a PDF (usando iText 7)
- Exportación a Excel (usando Apache POI)
- Reportes por período seleccionado

### 6. Panel de Control (Dashboard)
- Vista resumida con:
  - Balance total (ingresos - gastos)
  - Total de ingresos
  - Total de gastos
- Tarjetas con Material Design

## Arquitectura Técnica

### Base de Datos (Room)
La aplicación utiliza Room como ORM sobre SQLite con 5 entidades principales:

1. **Category**: Categorías principales
2. **Subcategory**: Subcategorías vinculadas a categorías
3. **Period**: Períodos de tiempo
4. **Income**: Registros de ingresos
5. **Expense**: Registros de gastos

Todas las entidades incluyen:
- Claves primarias auto-incrementales
- Timestamps de creación
- Relaciones con claves foráneas
- Índices para optimizar consultas

### Capa de Datos
- **DAOs (Data Access Objects)**: 5 DAOs con operaciones CRUD completas
- **Repository Pattern**: ExpenseRepository centraliza el acceso a datos
- **LiveData**: Para observación reactiva de cambios en la base de datos
- **Coroutines**: Para operaciones asíncronas

### Interfaz de Usuario
- **Material Design 3**: Componentes modernos y atractivos
- **Navigation Drawer**: Menú lateral deslizante
- **6 Fragmentos principales**:
  - Dashboard (Panel de control)
  - Income (Ingresos)
  - Expense (Gastos)
  - Category (Categorías y subcategorías)
  - Period (Períodos)
  - Reports (Reportes)
- **ViewBinding**: Para acceso seguro a vistas
- Layouts responsivos con CardViews

### Dependencias Principales
```kotlin
// Core Android
androidx.core:core-ktx:1.12.0
androidx.appcompat:appcompat:1.6.1
com.google.android.material:material:1.11.0

// Lifecycle & ViewModel
androidx.lifecycle:lifecycle-*:2.7.0

// Navigation
androidx.navigation:navigation-*:2.7.6

// Room Database
androidx.room:room-*:2.6.1

// Coroutines
kotlinx-coroutines-android:1.7.3

// PDF Generation
itext7-core:7.2.5

// Excel Generation
apache.poi:poi:5.2.5
apache.poi:poi-ooxml:5.2.5
```

## Estructura del Proyecto

```
app/src/main/
├── java/com/example/controlgastos/
│   ├── data/
│   │   ├── entities/          # Entidades Room
│   │   │   ├── Category.kt
│   │   │   ├── Subcategory.kt
│   │   │   ├── Period.kt
│   │   │   ├── Income.kt
│   │   │   └── Expense.kt
│   │   ├── dao/               # Data Access Objects
│   │   │   ├── CategoryDao.kt
│   │   │   ├── SubcategoryDao.kt
│   │   │   ├── PeriodDao.kt
│   │   │   ├── IncomeDao.kt
│   │   │   └── ExpenseDao.kt
│   │   ├── repository/
│   │   │   └── ExpenseRepository.kt
│   │   ├── AppDatabase.kt     # Configuración Room
│   │   └── Converters.kt      # Type converters
│   ├── ui/
│   │   ├── income/
│   │   │   └── IncomeFragment.kt
│   │   ├── expense/
│   │   │   └── ExpenseFragment.kt
│   │   ├── category/
│   │   │   └── CategoryFragment.kt
│   │   ├── period/
│   │   │   └── PeriodFragment.kt
│   │   └── reports/
│   │       └── ReportsFragment.kt
│   ├── MainActivity.kt
│   └── DashboardFragment.kt
├── res/
│   ├── layout/                # Layouts XML
│   ├── menu/                  # Menús de navegación
│   ├── values/
│   │   ├── strings.xml        # Textos en español
│   │   ├── colors.xml
│   │   ├── dimens.xml
│   │   └── styles.xml
│   └── mipmap-*/             # Iconos de la app
└── AndroidManifest.xml
```

## Compilación y Despliegue

### Requisitos
- Android Studio Arctic Fox o superior
- JDK 11
- Android SDK 33
- Gradle 8.11.1

### Compilación Local
```bash
./gradlew assembleDebug
```

### GitHub Actions (CI/CD)
El repositorio incluye un workflow automático que:
1. Se ejecuta en cada push o PR
2. Configura el entorno Android
3. Compila el APK de debug
4. Sube el APK como artefacto descargable

#### Descargar APK desde GitHub Actions:
1. Ve a la pestaña **Actions** en GitHub
2. Selecciona el workflow "Android Build"
3. Elige la ejecución más reciente
4. Descarga el artefacto "app-debug"
5. Transfiere el APK a tu dispositivo Android
6. Instala la aplicación (habilita "Orígenes desconocidos" si es necesario)

## Configuración de la Base de Datos

La base de datos se crea automáticamente al iniciar la aplicación por primera vez:

- **Nombre**: `control_gastos_database`
- **Versión**: 1
- **Modo**: Destructive migration (útil durante desarrollo)

## Próximos Pasos de Desarrollo

### Funcionalidades Pendientes
1. **CRUD Completo**: Implementar formularios de creación y edición
2. **Listas con RecyclerView**: Mostrar datos en listas desplazables
3. **ViewModels**: Separar lógica de negocio de la UI
4. **Validación de Formularios**: Verificar datos antes de guardar
5. **Date Pickers**: Selección de fechas intuitiva
6. **Búsqueda y Filtros**: Encontrar registros rápidamente
7. **Generación de Reportes**: Implementar lógica de exportación PDF/Excel
8. **Gráficos**: Visualización de datos con charts
9. **Copias de Seguridad**: Export/Import de la base de datos
10. **Temas**: Soporte para modo oscuro

### Mejoras de UI/UX
- Animaciones y transiciones
- Confirmaciones antes de eliminar
- Mensajes toast/snackbar
- Indicadores de carga
- Estados vacíos con ilustraciones
- Onboarding para nuevos usuarios

### Optimizaciones
- Paginación de listas largas
- Caché de imágenes
- Compresión de datos
- Tests unitarios e instrumentados

## Permisos de la Aplicación

- `INTERNET`: Para futuras funcionalidades en línea
- `ACCESS_NETWORK_STATE`: Verificar conectividad
- `WRITE_EXTERNAL_STORAGE` (hasta API 28): Guardar reportes
- `READ_EXTERNAL_STORAGE` (hasta API 32): Leer reportes

## Licencia

Este proyecto está bajo la licencia especificada en el archivo LICENSE del repositorio.

## Soporte y Contribuciones

Para reportar problemas o sugerir mejoras, por favor abre un issue en el repositorio de GitHub.

---

**Versión**: 1.0  
**Última actualización**: Febrero 2026
