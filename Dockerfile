FROM emqx2:latest
MAINTAINER zym
# 参数
ENV KAFKA_ADDRESS=127.0.0.1
ENV KAFKA_PORT=9093
ENV TOPIC_NAME=emqx-topic
# 工作目录
ENV MYPATH /usr/soft/emqx/emqx/_build/emqx/rel/emqx
WORKDIR $MYPATH
ENV PATH $MYPATH/bin:$PATH
# 暴漏端口
EXPOSE 1883 8083 8084 8883 18083
ENTRYPOINT ["docker-run.sh"]
CMD ["emqx","foreground"]
