FROM emqx:4.3.12-with-kafka
MAINTAINER zym
# 工作目录
ENV MYPATH /usr/soft/emqx/emqx/_build/emqx/rel/emqx
WORKDIR $MYPATH
ENV PATH $MYPATH/bin:$PATH
# 暴漏端口
EXPOSE 1883 8083 8084 8883 18083
CMD ["emqx","foreground"]