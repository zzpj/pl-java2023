#!/bin/bash

SRC_DIR=../certs/
TLS=example_client_tls
SIGN=example_client_signing
DESTINATION=../src/main/resources/
FILENAME=keystore-premium.jks
# TODO: pass the password
./keygen-generic.sh $SRC_DIR $TLS $SIGN $DESTINATION $FILENAME
echo "Keystore has been generated."
