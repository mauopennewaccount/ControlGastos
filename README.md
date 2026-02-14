# ControlGastos
Aplicación Android para administrar gastos personales

## 📱 Características

### Gestión de Ingresos
- Registra ingresos por tipo (Tarjeta, Billetera, Monedas)
- Asigna estados: Pendiente, Pagado, Inactivo
- Almacena descripción y monto

### Gestión de Gastos  
- Registra gastos con categorías y subcategorías
- Asigna estados: Pendiente, Pagado, Inactivo
- Almacena descripción, cantidad y descripción adicional

### Categorías y Subcategorías
- Crea y administra categorías personalizadas
- Crea subcategorías asociadas a cada categoría
- Organiza tus gastos de forma estructurada

### Períodos
- Crea períodos con rango de fechas
- Agrupa registros por período
- Clona períodos completos con todos sus registros

### Base de Datos
- Almacenamiento local con SQLite usando Room
- Persistencia de datos offline
- Relaciones entre entidades

### Reportes
- Generación de reportes PDF (próximamente)
- Generación de reportes Excel (próximamente)
- Resumen de ingresos, gastos y balance

## 🔧 Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **UI**: Material Design 3
- **Base de Datos**: Room (SQLite)
- **Arquitectura**: MVVM (Model-View-ViewModel)
- **Navegación**: Navigation Component
- **Async**: Kotlin Coroutines
- **Lifecycle**: LiveData, ViewModel

## 🚀 Compilación Automática con GitHub Actions

Este repositorio incluye un workflow de GitHub Actions que compila automáticamente el proyecto Android y genera archivos APK.

### Características del Workflow

- **Compilación automática**: Se ejecuta en cada push o pull request a las ramas `main`, `master` o `develop`
- **Compilación manual**: También se puede ejecutar manualmente desde la pestaña "Actions" en GitHub
- **Generación de APKs**: Genera tanto APK de debug como release (si está configurado)
- **Artifacts descargables**: Los APKs generados se pueden descargar desde la página del workflow

### Cómo usar

1. **Automático**: El workflow se ejecuta automáticamente cuando:
   - Haces push a las ramas principales (main, master, develop)
   - Abres o actualizas un pull request

2. **Manual**: Para ejecutar el workflow manualmente:
   - Ve a la pestaña "Actions" en GitHub
   - Selecciona "Android Build" en la lista de workflows
   - Haz clic en "Run workflow"
   - Selecciona la rama y haz clic en "Run workflow"

3. **Descargar el APK**:
   - Ve a la pestaña "Actions"
   - Selecciona el workflow ejecutado
   - En la sección "Artifacts", encontrarás los APKs generados
   - Descarga `app-debug` para instalar en tu dispositivo Android

## 📦 Instalación en Dispositivo Android

1. Descarga el APK desde GitHub Actions
2. Habilita la instalación de aplicaciones de fuentes desconocidas en tu dispositivo:
   - Ve a Configuración > Seguridad > Fuentes desconocidas
   - O Configuración > Aplicaciones > Acceso especial > Instalar apps desconocidas
3. Abre el archivo APK descargado
4. Sigue las instrucciones en pantalla para instalar

## 🏗️ Estructura del Proyecto

```
app/
├── src/
│   └── main/
│       ├── java/com/example/controlgastos/
│       │   ├── database/          # Room database, DAOs, Repository
│       │   ├── models/            # Entidades (Category, Expense, Income, etc.)
│       │   ├── ui/                # Fragments
│       │   ├── viewmodels/        # ViewModels
│       │   └── MainActivity.kt    # Actividad principal
│       ├── res/
│       │   ├── layout/            # Layouts XML
│       │   ├── values/            # Strings, Colors, Themes
│       │   ├── menu/              # Menú de navegación
│       │   └── navigation/        # Navigation graph
│       └── AndroidManifest.xml
└── build.gradle
```

## 🎯 Características de la Base de Datos

### Entidades
- **Category**: Categorías de gastos
- **Subcategory**: Subcategorías asociadas a categorías
- **Period**: Períodos con rango de fechas
- **Income**: Registro de ingresos
- **Expense**: Registro de gastos

### Relaciones
- Subcategorías vinculadas a Categorías (CASCADE delete)
- Ingresos y Gastos vinculados a Períodos (CASCADE delete)
- Gastos vinculados a Categorías y Subcategorías (SET NULL on delete)

## 📝 Próximas Características

- [ ] Implementación completa de generación de reportes PDF
- [ ] Implementación completa de generación de reportes Excel
- [ ] Gráficos y estadísticas
- [ ] Filtros avanzados
- [ ] Exportar/Importar datos
- [ ] Modo oscuro
- [ ] Notificaciones de recordatorios

### Requisitos del Proyecto

Para que el workflow funcione correctamente, tu proyecto Android debe:
- Estar configurado con Gradle
- Incluir el archivo `gradlew` (Gradle Wrapper)
- Tener la estructura estándar de proyecto Android con la carpeta `app/`

### Configuración

El workflow está configurado para:
- Usar JDK 17
- Instalar Android SDK automáticamente
- Cachear dependencias de Gradle para compilaciones más rápidas
- Generar APKs de debug y release

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## 👨‍💻 Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o pull request para sugerencias o mejoras.

