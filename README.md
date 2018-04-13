# AndroidThreadPool

## 使用方法

### 基本使用

1. 使用
	
	``` android
	Future<?> future = ExecutorSupplier.getInstance()
                .getBackgroundTasksExecutor()
                .submit(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
	```

2. 取消线程

	```android
	future.cancle(true);
	```

### 设置线程的优先等级使用

1. 使用

	``` android
	 Future<?> future = ExecutorSupplier.getInstance()
	            .getBackgroundTasksExecutor()
	            .submit(new PriorityRunnable(Priority.HIGH) {
	                @Override
	                public void run() {
	                    
	                }
	            });
	```

2. 等级设置

	等级设置有四种

	* Priority.LOW:低
	* Priority.MEDIUM：中
	* Priority.HIGH：高
	* Priority.IMMEDIATE：最高

3. 取消线程

	```android
	future.cancle(true);
	```

