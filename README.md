fluentd-log4j-appender
======================

# Overview

An appender for Log4j to send logs to [Fluentd](http://github.com/fluent/fluentd) daemon.

# Usage

Example for `log4j.properties` file :

      log4j.rootLogger=ERROR, Console, Fluentd
      
      log4j.appender.Console=...
      ...
            
      log4j.appender.Fluentd=org.fluentd.logger.sender.appender.FluentAppender
      log4j.appender.Fluentd.host=host-with-fluentd
      log4j.appender.Fluentd.port=24224
      log4j.appender.Fluentd.tag=mytag
      log4j.appender.Fluentd.label=mylabel
