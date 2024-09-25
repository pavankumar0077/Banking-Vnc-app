output_file="stats_4jan_vnc.log"

# Run docker stats and append the output to the file
for i in {1..500}; do
#date +"%Y-%m-%dT%H:%M:%S" >> "$output_file"
#docker stats 9d47c6e69677 --no-stream --format "{{.Container}}\t{{.CPUPerc}}\t{{.MemUsage}}\t$(date +"%Y-%m-%dT%H:%M:%S")" >> "$output_file"
docker stats 911f988ee94b --no-stream --format "{{.Container}}\t{{.CPUPerc}}\t{{.MemUsage}}\t$(date +"%Y-%m-%dT%H:%M:%S")" >> "$output_file"
sleep 0.2
done
