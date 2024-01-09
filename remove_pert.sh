#!/bin/bash

# Input TSV file
input_file="stats_http_f.dat"
#input_file="stats_vnc.tsv"
#input_file="stats_clear.tsv"

# Output TSV file
#output_file="stats_mec.tsv"
#output_file="stats_clear.tsv"
output_file="stats_http_final1.dat"

#sed 's/%//g' "$input_file" > "$output_file"
#sed 's/\/ 15.33GiB//g' "$input_file" > "$output_file"
sed 's/GiB//g' "$input_file" > "$output_file"
#sed  -e 's/%//g' -e 's/MiB//g' -e 's/\/ 15.3MiB//g' "$input_file" > "$output_file"
#sed 's/\/ 12.3MB//g' "$input_file" > "$output_file"
echo "Percent symbols removed from $input_file and saved to $output_file"

