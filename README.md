# ControlGastos
Aplicación Android para administrar gastos personales

## 🔄 Copiar Este Proyecto a Tu Repositorio

¿Quieres usar este proyecto como base? Puedes copiarlo fácilmente a tu propio repositorio:

**Guía Rápida**: [QUICK_MIRROR_GUIDE.md](QUICK_MIRROR_GUIDE.md)
**Guía Completa**: [MIRROR_REPOSITORY.md](MIRROR_REPOSITORY.md)

```bash
# Método más rápido (copia todo el historial)
./mirror-repository.sh https://github.com/tuusuario/tu-repo.git
```

---

## 📱 Características

### Gestión Completa de Finanzas Personales
- **Registro de Ingresos**: Tarjeta, billetera, monedas
- **Control de Gastos**: Con categorías, subcategorías y estados (pendiente, pagado, inactivo)
- **Categorización**: Sistema completo de categorías y subcategorías
- **Períodos**: Organiza tus registros por rangos de fechas
- **Clonado de Períodos**: Duplica períodos completos con todos sus registros
- **Reportes**: Exporta a PDF y Excel
- **Dashboard**: Visualiza tu balance, ingresos y gastos totales

## 🏗️ Arquitectura

- **Lenguaje**: Kotlin
- **Base de Datos**: Room (SQLite)
- **UI**: Material Design 3 con Navigation Drawer
- **Arquitectura**: MVVM con Repository Pattern
- **Programación Asíncrona**: Kotlin Coroutines
- **Observación de Datos**: LiveData

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

### Instalación en tu Dispositivo

1. Descarga el APK desde GitHub Actions
2. Transfiere el archivo a tu dispositivo Android
3. Habilita "Instalar desde fuentes desconocidas" en la configuración
4. Abre el APK y sigue las instrucciones de instalación

## 🛠️ Compilación Local

### Requisitos

- Android Studio Arctic Fox o superior
- JDK 11
- Android SDK 33
- Gradle 8.11.1

### Pasos

1. Clona el repositorio:
```bash
git clone https://github.com/mauopennewaccount/ControlGastos.git
```

2. Abre el proyecto en Android Studio

3. Sincroniza Gradle:
```bash
./gradlew build
```

4. Ejecuta en un emulador o dispositivo físico

## 📋 Requisitos del Sistema

- **Android**: Versión mínima 7.0 (API 24)
- **Android**: Versión objetivo 13 (API 33)
- **Espacio**: ~30 MB

## 📖 Documentación Completa

Para detalles técnicos, arquitectura y guía de desarrollo, consulta [DOCUMENTATION.md](DOCUMENTATION.md)

## 🗂️ Estructura de la Base de Datos

- **Categories**: Categorías principales
- **Subcategories**: Subcategorías asociadas
- **Periods**: Períodos de tiempo
- **Income**: Registros de ingresos
- **Expense**: Registros de gastos

## 🎨 Capturas de Pantalla

_(Las capturas de pantalla se añadirán una vez compilada la aplicación)_

## 🤝 Contribuir

Las contribuciones son bienvenidas. Por favor:

1. Haz fork del repositorio
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto está bajo la licencia especificada en el archivo [LICENSE](LICENSE).

## 👤 Autor

**mauopennewaccount**

## 📞 Soporte

Si encuentras algún problema o tienes sugerencias, por favor abre un [issue](https://github.com/mauopennewaccount/ControlGastos/issues).

---

⭐ Si te gusta este proyecto, no olvides darle una estrella en GitHub!
