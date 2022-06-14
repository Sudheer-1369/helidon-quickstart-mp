#
# Simulates the topic onto which incoming transmissions are notified to interested parties
#
kafka-topics --if-exists --delete --topic transmission.received --bootstrap-server localhost:9092
kafka-topics --create --topic transmission.received --bootstrap-server localhost:9092