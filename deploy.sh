#!/bin/sh
DIRNAME=`pwd`
EAR_FILE="semillero-ear-1.0-SNAPSHOT.ear"
EAR_DIR_COMPILADO="${DIRNAME}/semillero-padre/semillero-ear/target"

BASEDIR=`cd "$DIRNAME/.." >/dev/null; pwd`
WILD_FLY="${BASEDIR}/wildfly-15.0.1.Final"
WILD_FLY_DEPLOY_DIR="${WILD_FLY}/standalone/deployments"
WILD_FLY_BIN="${WILD_FLY}/bin"

echo "EJECUTANDO COMPILADOR..."
mvn clean install

echo "LIMPIANDO ARCHIVOS EAR..."
echo `rm "$WILD_FLY_DEPLOY_DIR"/"$EAR_FILE"`
echo `rm "$WILD_FLY_DEPLOY_DIR"/"$EAR_FILE".deployed`

echo "COPIANDO ARCHIVOS EAR COMPILADO..."
echo `cp "$EAR_DIR_COMPILADO"/"$EAR_FILE" "$WILD_FLY_DEPLOY_DIR"/"$EAR_FILE"`

echo "INICIANDO SERVIDOR WILDFLY..."
cd $WILD_FLY_BIN
./standalone.sh

echo "SERVIDOR WILDFLY TERMINADO"
cd $DIRNAME

