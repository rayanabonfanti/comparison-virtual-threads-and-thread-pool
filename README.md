# Project Comparison of Virtual Threads and Thread Pool

## Overview

This project aims to compare the performance and usability of virtual threads in Java 21 against traditional thread pools. The project includes various benchmarks and use cases to demonstrate the differences and potential benefits of using virtual threads.

### Language and Tools

- **Language:** Java 21
- **Build:** Maven
- **Frameworks:**
    - Spring Boot 3.2.5

## Review
This example demonstrates how virtual threads in Java 21 are 90% faster than the thread pool when using 2,000 threads. When the thread pool uses more than 2,000 threads, errors occur because my Mac does not support that much memory. In contrast, virtual threads do not require specifying a number of threads; they are managed automatically.
 
## Contributions

Contributions are welcome! Open issues, propose new features, or send pull requests to improve the system.

## Contact

For more information or questions, please contact [rayanabonfanti@gmail.com].
