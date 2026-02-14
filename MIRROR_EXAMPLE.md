# Ejemplo de Uso - Migración de Repositorio

## 📹 Demostración de Uso

### Escenario: Copiar el proyecto ControlGastos a tu cuenta personal

---

## Paso 1: Crear el Nuevo Repositorio

### En GitHub:
1. Ve a https://github.com/new
2. Ingresa el nombre del repositorio: `mi-control-gastos`
3. **IMPORTANTE**: NO selecciones ninguna opción de inicialización
   - ❌ NO marques "Add a README file"
   - ❌ NO selecciones ".gitignore"
   - ❌ NO selecciones "Choose a license"
4. Click en "Create repository"
5. Copia la URL que aparece: `https://github.com/tuusuario/mi-control-gastos.git`

**Captura de pantalla sugerida:**
```
┌─────────────────────────────────────────────┐
│ Create a new repository                     │
├─────────────────────────────────────────────┤
│ Repository name: mi-control-gastos          │
│                                             │
│ Description (optional):                     │
│ [Android expense management app]           │
│                                             │
│ ○ Public  ● Private                        │
│                                             │
│ Initialize this repository with:            │
│ ☐ Add a README file                        │
│ ☐ Add .gitignore: None                     │
│ ☐ Choose a license: None                   │
│                                             │
│            [Create repository]              │
└─────────────────────────────────────────────┘
```

---

## Paso 2: Ejecutar el Script de Migración

### Opción A: Script Automatizado (Recomendado)

```bash
# En tu terminal, navega al proyecto
cd /ruta/a/ControlGastos

# Ejecuta el script con la URL de tu nuevo repositorio
./mirror-repository.sh https://github.com/tuusuario/mi-control-gastos.git
```

### Salida esperada:

```
===================================
   Migración de Repositorio
   ControlGastos
===================================

ℹ URL del nuevo repositorio: https://github.com/tuusuario/mi-control-gastos.git

¿Deseas continuar con la migración? (s/n): s

ℹ Paso 1: Creando clon espejo del repositorio actual...
✓ Clon espejo creado

ℹ Paso 2: Configurando nuevo repositorio remoto...
✓ Nuevo repositorio configurado

ℹ Paso 3: Enviando todo el contenido al nuevo repositorio...

Esto incluye:
  - Todas las ramas
  - Todos los tags
  - Todo el historial de commits

Enumerating objects: 150, done.
Counting objects: 100% (150/150), done.
Delta compression using up to 8 threads
Compressing objects: 100% (95/95), done.
Writing objects: 100% (150/150), 250.00 KiB | 5.00 MiB/s, done.
Total 150 (delta 45), reused 120 (delta 35), pack-reused 0
remote: Resolving deltas: 100% (45/45), done.
To https://github.com/tuusuario/mi-control-gastos.git
 * [new branch]      copilot/create-personal-expense-tracker-again -> copilot/create-personal-expense-tracker-again

✓ ¡Migración completada exitosamente!

ℹ Tu proyecto ahora está disponible en: https://github.com/tuusuario/mi-control-gastos.git

¿Deseas eliminar el directorio temporal? (s/n): s
✓ Directorio temporal eliminado

✓ ===================================
✓    ¡Proceso Completado!
✓ ===================================

Próximos pasos:
  1. Visita tu nuevo repositorio: https://github.com/tuusuario/mi-control-gastos.git
  2. Clona el nuevo repositorio localmente si lo necesitas
  3. Configura GitHub Actions si es necesario
```

---

## Paso 3: Verificar el Nuevo Repositorio

### En el Navegador:
1. Ve a `https://github.com/tuusuario/mi-control-gastos`
2. Deberías ver:
   - ✅ El README.md principal
   - ✅ La estructura de carpetas (app/, gradle/, etc.)
   - ✅ Todos los archivos de documentación
   - ✅ El historial de commits

### Estructura visible:
```
mi-control-gastos/
├── 📄 README.md
├── 📄 LICENSE
├── 📄 DOCUMENTATION.md
├── 📄 PROJECT_SUMMARY.md
├── 📄 ARCHITECTURE.md
├── 📄 QUICKSTART.md
├── 📄 MIRROR_REPOSITORY.md
├── 📄 QUICK_MIRROR_GUIDE.md
├── 📁 app/
│   ├── 📁 src/
│   └── 📄 build.gradle.kts
├── 📁 gradle/
├── 📄 build.gradle.kts
├── 📄 settings.gradle.kts
├── 📄 gradlew
└── 📁 .github/
    └── 📁 workflows/
        └── 📄 android-build.yml
```

---

## Paso 4: Clonar Localmente (Opcional)

Si quieres trabajar en tu copia local:

```bash
# En tu directorio de proyectos
cd ~/proyectos

# Clona tu nuevo repositorio
git clone https://github.com/tuusuario/mi-control-gastos.git

# Entra al directorio
cd mi-control-gastos

# Verifica que todo esté bien
ls -la
git log --oneline -10
```

---

## Paso 5: Configurar GitHub Actions

### Habilitar Actions:
1. Ve a tu repositorio en GitHub
2. Click en la pestaña **"Actions"**
3. Si ves un mensaje, click en **"I understand my workflows, go ahead and enable them"**

### Ejecutar el Workflow Manualmente:
1. En Actions, selecciona **"Android Build"**
2. Click en **"Run workflow"** (botón verde a la derecha)
3. Selecciona la rama (generalmente `copilot/create-personal-expense-tracker-again`)
4. Click en **"Run workflow"**

### Esperar y Descargar:
1. Espera unos minutos a que compile (verás un círculo amarillo → check verde)
2. Click en el workflow que se ejecutó
3. Baja a la sección **"Artifacts"**
4. Descarga **"app-debug"**
5. Extrae el APK y ¡listo para instalar en tu Android!

---

## Resultado Final

### Lo que tienes ahora:

1. ✅ **Tu propio repositorio** con el código completo
2. ✅ **Todo el historial** de commits preservado
3. ✅ **GitHub Actions** funcionando para generar APKs
4. ✅ **Toda la documentación** incluida
5. ✅ **Listo para modificar** y personalizar

### Lo que puedes hacer:

- ✨ Personalizar el código para tus necesidades
- 🎨 Cambiar colores y diseño
- 📊 Añadir nuevas funcionalidades
- 🔒 Mantenerlo privado o hacerlo público
- 🚀 Compilar APKs cuando quieras
- 🤝 Invitar colaboradores

---

## Ejemplo con Comandos Manuales

Si prefieres hacerlo sin el script:

```bash
# 1. Clonar como mirror
git clone --mirror https://github.com/mauopennewaccount/ControlGastos.git temp-mirror

# 2. Entrar al directorio
cd temp-mirror

# 3. Cambiar el remoto
git remote set-url origin https://github.com/tuusuario/mi-control-gastos.git

# 4. Push mirror
git push --mirror

# 5. Limpiar
cd ..
rm -rf temp-mirror

# 6. Verificar
git clone https://github.com/tuusuario/mi-control-gastos.git
cd mi-control-gastos
ls -la
```

---

## Tiempos Estimados

- ⏱️ **Crear repositorio en GitHub**: 1 minuto
- ⏱️ **Ejecutar script de migración**: 2-3 minutos
- ⏱️ **Verificar en navegador**: 30 segundos
- ⏱️ **Configurar GitHub Actions**: 1 minuto
- ⏱️ **Primera compilación de APK**: 5-8 minutos

**Total: ~10-15 minutos para tener tu copia completa funcionando** ⚡

---

## Casos de Uso Reales

### Caso 1: Estudiante
```
Quiero usar este proyecto como base para mi proyecto final.
→ Usa mirror completo
→ Añade tu nombre y modificaciones
→ Mantén privado hasta entregar
```

### Caso 2: Desarrollador
```
Quiero crear mi propia app de gastos basada en este código.
→ Usa mirror completo
→ Personaliza todo el diseño
→ Añade tus funcionalidades únicas
→ Publica tu versión
```

### Caso 3: Empresa
```
Necesitamos una app interna de control de gastos.
→ Usa mirror completo
→ Repositorio privado de la empresa
→ Personaliza con logo y colores corporativos
→ Despliega internamente
```

---

## ¿Problemas?

### Error: "Authentication failed"
```bash
# Solución: Usa tu token de GitHub
./mirror-repository.sh https://TU_TOKEN@github.com/tuusuario/mi-repo.git
```

### Error: "Repository not found"
- Verifica que hayas creado el repositorio primero
- Verifica que la URL sea correcta
- Asegúrate de tener permisos

### El script dice "Permission denied"
```bash
# Dale permisos de ejecución
chmod +x mirror-repository.sh
./mirror-repository.sh https://...
```

---

## Resumen del Ejemplo

**Antes**: 
- Código en repositorio original de otro usuario
- No puedes modificar directamente

**Después**:
- ✅ Tu propia copia en tu cuenta
- ✅ Puedes modificar libremente
- ✅ GitHub Actions funciona
- ✅ Historial preservado
- ✅ Listo para usar y personalizar

**Comando usado**:
```bash
./mirror-repository.sh https://github.com/tuusuario/mi-control-gastos.git
```

**Tiempo total**: ~10 minutos

**Resultado**: Tu propia versión del proyecto lista para usar 🎉

---

**¡Ahora el proyecto es tuyo!** Modifícalo, mejóralo y hazlo único. 🚀
