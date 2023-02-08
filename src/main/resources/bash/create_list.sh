#!/bin/bash

for i in $(seq -f "%05g" 1 50)
do
  echo "\"P$i\","
done