#!/bin/bash
# Script para copiar/migrar el repositorio ControlGastos a un nuevo repositorio

set -e  # Exit on error

echo "==================================="
echo "   Migración de Repositorio"
echo "   ControlGastos"
echo "==================================="
echo ""

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Function to print colored messages
print_success() {
    echo -e "${GREEN}✓ $1${NC}"
}

print_error() {
    echo -e "${RED}✗ $1${NC}"
}

print_info() {
    echo -e "${YELLOW}ℹ $1${NC}"
}

# Check if new repository URL is provided
if [ -z "$1" ]; then
    print_error "Error: Debes proporcionar la URL del nuevo repositorio"
    echo ""
    echo "Uso:"
    echo "  ./mirror-repository.sh <URL_NUEVO_REPOSITORIO>"
    echo ""
    echo "Ejemplos:"
    echo "  ./mirror-repository.sh https://github.com/usuario/nuevo-repo.git"
    echo "  ./mirror-repository.sh git@github.com:usuario/nuevo-repo.git"
    echo ""
    exit 1
fi

NEW_REPO_URL="$1"
TEMP_DIR="ControlGastos-mirror-temp"

print_info "URL del nuevo repositorio: $NEW_REPO_URL"
echo ""

# Ask for confirmation
read -p "¿Deseas continuar con la migración? (s/n): " -n 1 -r
echo ""
if [[ ! $REPLY =~ ^[SsYy]$ ]]; then
    print_error "Operación cancelada"
    exit 1
fi

echo ""
print_info "Paso 1: Creando clon espejo del repositorio actual..."

# Create mirror clone
if [ -d "$TEMP_DIR" ]; then
    print_info "Eliminando directorio temporal existente..."
    rm -rf "$TEMP_DIR"
fi

git clone --mirror https://github.com/mauopennewaccount/ControlGastos.git "$TEMP_DIR"
print_success "Clon espejo creado"

echo ""
print_info "Paso 2: Configurando nuevo repositorio remoto..."

cd "$TEMP_DIR"
git remote set-url origin "$NEW_REPO_URL"
print_success "Nuevo repositorio configurado"

echo ""
print_info "Paso 3: Enviando todo el contenido al nuevo repositorio..."
echo ""
print_info "Esto incluye:"
echo "  - Todas las ramas"
echo "  - Todos los tags"
echo "  - Todo el historial de commits"
echo ""

# Push everything to new repository
if git push --mirror; then
    print_success "¡Migración completada exitosamente!"
    echo ""
    print_info "Tu proyecto ahora está disponible en: $NEW_REPO_URL"
else
    print_error "Error al enviar los datos al nuevo repositorio"
    echo ""
    echo "Posibles causas:"
    echo "  - El repositorio de destino no existe"
    echo "  - No tienes permisos de escritura"
    echo "  - Problemas de autenticación"
    echo ""
    echo "Asegúrate de:"
    echo "  1. Haber creado el repositorio en GitHub/GitLab/Bitbucket"
    echo "  2. El repositorio esté vacío"
    echo "  3. Tener configuradas tus credenciales de Git"
    cd ..
    exit 1
fi

cd ..

echo ""
read -p "¿Deseas eliminar el directorio temporal? (s/n): " -n 1 -r
echo ""
if [[ $REPLY =~ ^[SsYy]$ ]]; then
    rm -rf "$TEMP_DIR"
    print_success "Directorio temporal eliminado"
fi

echo ""
print_success "==================================="
print_success "   ¡Proceso Completado!"
print_success "==================================="
echo ""
echo "Próximos pasos:"
echo "  1. Visita tu nuevo repositorio: $NEW_REPO_URL"
echo "  2. Clona el nuevo repositorio localmente si lo necesitas"
echo "  3. Configura GitHub Actions si es necesario"
echo ""
