FROM openjdk:8
Add target/food-order-processing.jar food-order-processing.jar
EXPOSE 8010
ENTRYPOINT ["java", "-jar", "food-order-processing.jar"] 