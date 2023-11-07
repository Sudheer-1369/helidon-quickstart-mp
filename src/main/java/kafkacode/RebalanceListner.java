/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package kafkacode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.OffsetCommitCallback;
import org.apache.kafka.common.TopicPartition;

public class RebalanceListner implements ConsumerRebalanceListener {

  private final KafkaConsumer consumer;
  private final Map<TopicPartition, OffsetAndMetadata> currentOffSets = new HashMap<>();

  public RebalanceListner(KafkaConsumer consumer) {
    this.consumer = consumer;
  }

  @Override
  public void onPartitionsRevoked(Collection<TopicPartition> collection) {
    System.out.println("Following partitions revoked");
    for (TopicPartition partition : collection) System.out.println(partition.partition());

    System.out.println("Following offsets comitted");
    for (TopicPartition tp : currentOffSets.keySet()) {
      System.out.println(tp.partition());
    }

    consumer.commitAsync(
        currentOffSets,
        new OffsetCommitCallback() {
          @Override
          public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
            if (e != null) {
              System.out.println("An error has occurred");
            } else {
              System.out.println("The offset commit was done properly");
            }
          }
        });
    currentOffSets.clear();
  }

  @Override
  public void onPartitionsAssigned(Collection<TopicPartition> collection) {

    // TODO Not useful now
  }
}
