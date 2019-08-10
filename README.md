# Spring-data-redis
redis详细案例





note：
    redis-demo：
        主要包含redis的相关内容
        -demo：
            -RedisDemo：单例连接和连接池连接的相关测试
            -JedisPoolDemo：通过读取配置文件applicationContext.xml进行redis数据读取

        -springdataredis
            -text
                -TestHash：Hash类型操作
                -TestList：List类型操作
                -TestSet：Set类型操作
                -TestValue：值类型操作
            -SpringDataRedis：
                配置文件：redis-config.properties、applicationContext-redis.xml
                功能描述：进行redis的String、set、hash、list等增删改查信息操作
        -jedisCluster
            -testJedisCluster：创建JedisCluster类连接redis集群。
            -JedisPoolConfig：
                配置文件：applicationContext-jediscluster.xml
                功能描述：根据读取redis集群配置文件测试Jedis连接集群

    redis-example
        Spring Data Redis综合案例测试
        步骤：
            1）引入依赖
            <!--缓存-->
                    <!-- https://mvnrepository.com/artifact/redis.clients/jedis -->
                    <dependency>
                        <groupId>redis.clients</groupId>
                        <artifactId>jedis</artifactId>
                        <version>2.9.0</version>
                    </dependency>
                    <dependency>
                        <groupId>org.springframework.data</groupId>
                        <artifactId>spring-data-redis</artifactId>
                        <version>1.7.2.RELEASE</version>
                    </dependency>
            2）创建配置文件
                将资源中的 redis-config.properties 和 applicationContext-redis.xml 创建至resources中
            3）后端服务实现层
