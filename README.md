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
Output (work to dispatch from queue): A (38), B (12), C (50)
```

# Inputs
The number of queue
```
int queueCnt = 3;
```
The maximum number of workitem to dispatch from queue, cannot be 0
```
int dispatchLimit = 100;
```
The number of workitem in each queue
```
Integer[] workItemQueueCnt = new Integer[]{50,12,50};
```
The weight of each queue, need not to be add up to 100. This is the ratio of distribution to each queue. Cannot be 0 (in case of 0 please simply remove it from the arrays).
```
Integer[] queueWeight = new Integer[]{3,2,5};
```
# Output
The sample rountine print out the number for each queue.
