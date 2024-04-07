# Base image for Grafana
FROM grafana/grafana:latest AS base

# Download plugin archive (replace with actual URL)
RUN wget https://github.com/grafana/grafana-infinity-datasource/releases/download/v2.4.0/yesoreyeram-infinity-datasource-2.4.0.zip -O /tmp/plugin.zip

# Unzip the archive (assuming unzip is available)
RUN unzip /tmp/plugin.zip -d /tmp/plugin && ls /tmp/plugin

# Intermediate stage to copy plugin files
FROM alpine:latest AS plugin_stage
COPY --from=base /tmp/plugin /tmp/plugin

# Final stage
FROM grafana/grafana:latest

# Copy plugin files from intermediate stage
COPY --from=plugin_stage /tmp/plugin /var/lib/grafana/plugins/

# Clean up temporary files (optional)
#RUN rm -rf /tmp/plugin.zip /tmp/plugin

# (Optional) Set environment variable for development mode (if needed)
# ENV GF_DEFAULT_APP_MODE=development

# Expose Grafana port
EXPOSE 3000

# Run Grafana
CMD ["grafana-server"]