all-student-name
![image](https://github.com/user-attachments/assets/03ba9296-af12-44f7-a704-4c863d68a0a7)
![image](https://github.com/user-attachments/assets/cc3831ad-acc4-48a5-9bd6-62f5d82dc0ca)
![image](https://github.com/user-attachments/assets/da145c57-db45-4feb-80bc-2d68e83737a2)
![image](https://github.com/user-attachments/assets/1ff5fdda-5fee-4a11-95e9-fe8a1564017e)

highest-gpa:
![image](https://github.com/user-attachments/assets/6f45ad8e-f6e1-4ae3-81c1-a9ff6c592a5f)
![image](https://github.com/user-attachments/assets/95cd2138-a989-417a-9896-ab2544517d6b)
![image](https://github.com/user-attachments/assets/ecb1d898-13f8-4ef4-9181-ac8e0c8949f2)
![image](https://github.com/user-attachments/assets/8abfced4-6f4a-4f30-b56c-42d2d57e4b89)

test plan script
![image](https://github.com/user-attachments/assets/2dc4f9e3-ed16-4bf9-852c-863a4e740a9e)
![image](https://github.com/user-attachments/assets/8ba80e16-2070-4ceb-8d71-60e26dc51584)
![Screenshot (1440)](https://github.com/user-attachments/assets/2dd5bb04-1fbe-4ae7-9734-d32fa1708584)


conclusion:
After completing the profiling and performance optimization process, we retested the application using JMeter and compared the new measurements with our initial results. The changes made to the /all-student-name endpoint—specifically, optimizing the joinStudentNames method by leveraging parallel streams and efficient string joining—resulted in a significant reduction in processing time, achieving an improvement of approximately 20%. Similarly, refactoring the /highest-gpa endpoint by modifying the findStudentWithHighestGpa method to use a direct repository query (findTopByOrderByGpaDesc) greatly reduced CPU time and overall processing time, meeting the performance improvement target. Overall, these optimizations have enhanced the application's responsiveness and scalability, confirming that the profiling and refactoring efforts were successful in achieving the desired performance gains.

Reflection:
1.What is the difference between the approach of performance testing with JMeter and profiling with IntelliJ Profiler in the context of optimizing application performance?

JMeter is used for performance testing by simulating multiple users and measuring response times, throughput, and error rates under load. It helps identify slow endpoints and overall system performance under stress. Meanwhile, IntelliJ Profiler provides detailed insights into method execution time, CPU usage, and memory consumption at the code level, allowing developers to pinpoint bottlenecks and optimize specific methods.

2. How does the profiling process help you in identifying and understanding the weak points in your application?
   
The profiling process helps by breaking down execution time into method-level details. It highlights which functions consume the most CPU and total execution time, allowing for targeted optimizations. Through the flame graph and method execution time analysis, we identified that getAllStudentsWithCourses() and findStudentWithHighestGpa() were the most resource-intensive methods, leading us to optimize them using batch fetching and direct queries.

3. Do you think IntelliJ Profiler is effective in assisting you to analyze and identify bottlenecks in your application code?
   
Yes, IntelliJ Profiler is highly effective in identifying bottlenecks. Unlike JMeter, which only measures external performance, the profiler provides deep insights into internal code execution, making it possible to pinpoint inefficient loops, redundant queries, and memory-heavy operations.

4. What are the main challenges you face when conducting performance testing and profiling, and how do you overcome these challenges?
   
One of the main challenges is ensuring consistency between test runs since JVM optimizations like Just-In-Time (JIT) compilation can affect initial performance readings. Another challenge is interpreting profiling data correctly to make impactful optimizations. To overcome this, we repeated profiling runs, ignored the first execution, and relied on CPU time rather than total time for accuracy.

5. What are the main benefits you gain from using IntelliJ Profiler for profiling your application code?
   
The main benefits include detailed insights into method execution time, ability to analyze memory allocation and CPU usage, and identification of inefficient database queries. This helped in optimizing the application by reducing redundant database calls and improving string operations.

6. How do you handle situations where the results from profiling with IntelliJ Profiler are not entirely consistent with findings from performance testing using JMeter?
   
If profiling results and JMeter findings are inconsistent, the first step is to ensure that both tests are run under similar conditions, such as using warm-up runs before measuring performance. If discrepancies persist, we analyze if JMeter’s load simulation causes resource contention that affects profiling results. In such cases, profiling under different load levels can help understand the actual bottleneck.

7. What strategies do you implement in optimizing application code after analyzing results from performance testing and profiling? How do you ensure the changes you make do not affect the application's functionality?
   
Optimization strategies implemented are as follows:

- Using batch fetching in database queries to reduce query overhead.
- Utilizing direct repository queries (findTopByOrderByGpaDesc()) to minimize CPU usage.
- Replacing inefficient string concatenation with Collectors.joining() in joinStudentNames().
- Running unit and integration tests after optimizations to ensure no functionality is broken.
- Comparing JMeter performance results before and after optimization to confirm at least a 20% improvement in response time.
