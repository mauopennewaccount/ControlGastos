# ControlGastos
Aplicación android para administrar gastos personales

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
