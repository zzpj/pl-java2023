#!/bin/bash

SRC_DIR=$1
TLS=$2
SIGN=$3
DESTINATION=$4
FILENAME=$5

TEMP_KEYSTORE_NAME=store-open.keys

set -e

if [ ! -d "$DESTINATION" ]; then
  printf "\nDirectory %s DOES NOT exist.\n\n" "$DESTINATION"
  exit
fi

printf "\nPlease provide a password of at least 6 characters."
printf "\nThis password should be used in your application to retrieve your certificates and keys.\n\n"
read -s -r PASSWORD

openssl pkcs12 -export -in "$SRC_DIR$TLS".cer -inkey "$SRC_DIR$TLS".key -name tls -password "pass:$PASSWORD" > tls.p12

keytool -importkeystore -srckeystore tls.p12 -destkeystore "$TEMP_KEYSTORE_NAME" -srcstoretype pkcs12 -alias tls -srcstorepass "$PASSWORD" -deststorepass "$PASSWORD"

echo "$DESTINATION$FILENAME" | xargs -n 1 cp "$TEMP_KEYSTORE_NAME"
rm "$TEMP_KEYSTORE_NAME"
rm tls.p12
