output_file="stats.log"

# Run docker stats and append the output to the file
for i in {1..750}; do
#date +"%Y-%m-%dT%H:%M:%S" >> "$output_file"
docker stats 580012334ee1 --no-stream --format "{{.Container}}\t{{.CPUPerc}}\t{{.MemUsage}}\t{{.NetIO}}\t$(date +"%s.%N")\t$(echo "$i")" >> "$output_file" &
sleep 0.1
done
