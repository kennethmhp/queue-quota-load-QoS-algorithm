# queue-quota-load-QoS-algorithm
A simple but proven (java based) algorithm to calculate the actual work to dispatch from queues, based on a quota assigned to each queue

# Scenario
Assume you have N work queues and there can be 0 to X workitems inside. There is a maximum limit of number of works to dispatch from the queues and there is a quota (%, add up to 100%) for each work queue. This algorithm calculate the number of work item to dispatch from queues.

Example 1, Normal case:
```
Dispatch Limit : 9
Queue (work in queue | Quota %): A (10|33), B (20|33), C (50|33)
Output (work to dispatch from queue): A (3), B (3), C (3)
```

Example 2, some queue is empty:
```
Dispatch Limit : 9
Queue (work in queue | Quota %): A (10|33), B (0|33), C (50|33)
Output (work to dispatch from queue): A (5*), B (0), C (4)
* round up for utilize dispatch limit
```

Example 3, some queue does not use up its own quota:
```
Dispatch Limit : 100
Queue (work in queue | Quota %): A (50|30), B (12|20), C (50|60)
Output (work to dispatch from queue): A (29), B (12), C (59*)
* round up for utilize dispatch limit
```

# Inputs
