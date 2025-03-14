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

conclusion:
After completing the profiling and performance optimization process, we retested the application using JMeter and compared the new measurements with our initial results. The changes made to the /all-student-name endpoint—specifically, optimizing the joinStudentNames method by leveraging parallel streams and efficient string joining—resulted in a significant reduction in processing time, achieving an improvement of approximately 20%. Similarly, refactoring the /highest-gpa endpoint by modifying the findStudentWithHighestGpa method to use a direct repository query (findTopByOrderByGpaDesc) greatly reduced CPU time and overall processing time, meeting the performance improvement target. Overall, these optimizations have enhanced the application's responsiveness and scalability, confirming that the profiling and refactoring efforts were successful in achieving the desired performance gains.
