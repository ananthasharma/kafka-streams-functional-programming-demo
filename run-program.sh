export KAFKA_API_KEY=<<set your API key here>>
export KAFKA_API_SECRET=<<set your API secret here>>
export SCHEMA_REGISTRY_API_KEY=<<set your API key here>>
export SCHEMA_REGISTRY_API_SECRET=<<set your API secret here>>
export SCHEMA_REGISTRY_URL=http://localhost:8081
export BOOT_STRAP_SERVERS=localhost:9092
export SPRING_PROFILES_ACTIVE=cloud
gradle clean bootRun
