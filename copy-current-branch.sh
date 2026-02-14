#!/bin/bash
# Script para copiar solo la rama actual a un nuevo repositorio

set -e

echo "==================================="
echo "   Copiar Rama Actual"
echo "   ControlGastos"
echo "==================================="
echo ""

# Colors
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m'

print_success() {
    echo -e "${GREEN}✓ $1${NC}"
}

print_error() {
    echo -e "${RED}✗ $1${NC}"
}

print_info() {
    echo -e "${YELLOW}ℹ $1${NC}"
}

if [ -z "$1" ]; then
    print_error "Error: Debes proporcionar la URL del nuevo repositorio"
    echo ""
    echo "Uso:"
    echo "  ./copy-current-branch.sh <URL_NUEVO_REPOSITORIO>"
    echo ""
    exit 1
fi

NEW_REPO_URL="$1"
CURRENT_BRANCH=$(git rev-parse --abbrev-ref HEAD)

print_info "Rama actual: $CURRENT_BRANCH"
print_info "Nuevo repositorio: $NEW_REPO_URL"
echo ""

read -p "¿Continuar? (s/n): " -n 1 -r
echo ""
if [[ ! $REPLY =~ ^[SsYy]$ ]]; then
    print_error "Operación cancelada"
    exit 1
fi

echo ""
print_info "Añadiendo nuevo repositorio remoto..."

# Add new remote (temporary)
git remote add new-origin "$NEW_REPO_URL" 2>/dev/null || {
    print_info "El remoto 'new-origin' ya existe, actualizando URL..."
    git remote set-url new-origin "$NEW_REPO_URL"
}

print_success "Remoto añadido"

echo ""
print_info "Enviando rama $CURRENT_BRANCH al nuevo repositorio..."

if git push new-origin "$CURRENT_BRANCH"; then
    print_success "¡Rama copiada exitosamente!"
    echo ""
    print_info "Para hacer que sea la rama principal en el nuevo repositorio:"
    echo "  git push new-origin $CURRENT_BRANCH:main"
    echo ""
    print_info "Para enviar todos los commits:"
    echo "  git push new-origin $CURRENT_BRANCH --force"
else
    print_error "Error al enviar la rama"
    git remote remove new-origin
    exit 1
fi

echo ""
read -p "¿Deseas eliminar el remoto temporal 'new-origin'? (s/n): " -n 1 -r
echo ""
if [[ $REPLY =~ ^[SsYy]$ ]]; then
    git remote remove new-origin
    print_success "Remoto eliminado"
fi

echo ""
print_success "¡Proceso completado!"
