#!/bin/bash
set -e

(cd frontend && npm run-script build)
gradle clean jar bootRepackage
cp build/libs/facturacion-1.0.0.jar docker/

pushd docker
docker build -t henrycm/demo .
docker-composer up