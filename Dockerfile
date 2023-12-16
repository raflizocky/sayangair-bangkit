# Use the official lightweight Python image.
# https://hub.docker.com/_/python
FROM python:3.10-slim

# Allow statements and log messages to immediately appear in the Knative logs
ENV PYTHONUNBUFFERED True

# Copy local code to the container image.
ENV APP_HOME /app
WORKDIR $APP_HOME
COPY . ./


# Install system dependencies
RUN apt-get update && apt-get install libgl1-mesa-glx -y



# Install production dependencies.
RUN apt-get install ffmpeg libsm6 libxext6 -y
RUN python -m pip install --upgrade pip
RUN pip install -r requirements.txt
RUN pip install keras-ocr
RUN pip install pandas
RUN pip install matplotlib
RUN pip install pillow
RUN pip install opencv-contrib-python
RUN pip install -U Flask
RUN pip install firebase
RUN pip install firebase-admin



# Set environment variable for libGL.so.1
ENV LD_LIBRARY_PATH=/usr/lib/x86_64-linux-gnu/mesa

# Run the web service on container startup. Here we use the gunicorn
# webserver, with one worker process and 8 threads.
# For environments with multiple CPU cores, increase the number of workers
# to be equal to the cores available.
# Timeout is set to 0 to disable the timeouts of the workers to allow Cloud Run to handle instance scaling.
CMD exec gunicorn --bind :$PORT --workers 1 --threads 8 --timeout 0 main:app