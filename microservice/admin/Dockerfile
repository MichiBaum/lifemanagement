FROM openjdk:16-jdk-alpine3.13 as build
WORKDIR /workspace/app

COPY . .

RUN ./admin/mvnw install -DskipTests
RUN mkdir -p admin/target/dependency && (cd admin/target/dependency; jar -xf ../*.jar)

FROM openjdk:16-jdk-alpine3.13
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","admin.Application"]