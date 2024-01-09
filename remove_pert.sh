#!/bin/bash

# Input TSV file
input_file="stats_vnc_f.log"

# Output TSV file
output_file="stats_vnc.tsv"


sed 's/%//g' "$input_file" > "$output_file"

echo "Percent symbols removed from $input_file and saved to $output_file"

