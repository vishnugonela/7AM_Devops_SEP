#!/bin/sh

# Get container name and IP
CONTAINER_NAME=$(hostname)
CONTAINER_IP=$(hostname -i)
CURRENT_DATE=$(date)

# Generate the HTML file
cat <<EOF > /usr/share/nginx/html/index.html
<!DOCTYPE >
<html>
  <head>
    <title>Container Details</title>
  </head>
  <body>
    <h1>Container Details</h1>
    <p><b>Container Name:</b> $CONTAINER_NAME</p>
    <p><b>Container IP:</b> $CONTAINER_IP</p>
    <p><b>Date:</b> $CURRENT_DATE</p>
  </body>
</html>

EOF

# Start NGINX
nginx -g "daemon off;"
sh
