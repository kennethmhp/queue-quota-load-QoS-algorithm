int queueCnt = 3;
int dispatchLimit = 100;
Integer[] workItemQueueCnt = new Integer[]{1,12,50};
Integer[] queueWeight = new Integer[]{30,2,50};

int[] output = new int[queueCnt];

int totalWeight = 0;
int workItemTotalCnt = 0;
//int queueCnt = queueCnt;

for (int w: queueWeight) {
	totalWeight += w;
}

for (int cc : workItemQueueCnt) {
	workItemTotalCnt += cc;
}


while (dispatchLimit > 0 && workItemTotalCnt > 0) {
	int[] dispatchCnt = new int[queueCnt];
	int dispatchRemain = dispatchLimit;
	for (int k = 0; k < queueCnt; ++k) {
		double r = (double)queueWeight[k] / totalWeight * dispatchLimit;
		
		int chQuota = (r > 1.0) ? ((int)Math.round(r)) : 1;
		if (dispatchRemain > chQuota) {
			dispatchCnt[k] = chQuota;
			dispatchRemain -= chQuota;
		}
		else {
			dispatchCnt[k] = dispatchRemain;
		}
	}
	int d;
	for (int k = 0; k < queueCnt && dispatchLimit > 0; dispatchLimit -= d, ++k) {
		d = Math.min(dispatchCnt[k], workItemQueueCnt[k]);
		output[k] += d;
		workItemQueueCnt[k] -= d;
		workItemTotalCnt -= d;
	}
}

for (int k:output) {
	System.out.println(k);
}
