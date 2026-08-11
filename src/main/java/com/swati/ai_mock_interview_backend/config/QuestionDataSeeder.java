package com.swati.ai_mock_interview_backend.config;

import com.swati.ai_mock_interview_backend.entity.Question;
import com.swati.ai_mock_interview_backend.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionDataSeeder {

    @Bean
    CommandLineRunner seedQuestions(QuestionRepository repository) {
        return args -> {
            seedSubject(repository, "Java", "Core Java", "Easy", new String[]{"JVM", "JRE", "JDK", "class", "object", "constructor", "access modifiers", "inheritance", "interface", "exception"});
            seedSubject(repository, "Java", "Core Java", "Medium", new String[]{"== versus equals()", "ArrayList versus LinkedList", "HashMap", "method overloading", "method overriding", "StringBuilder versus StringBuffer", "checked versus unchecked exceptions", "try-catch-finally", "multithreading", "garbage collection"});
            seedSubject(repository, "Java", "Core Java", "Hard", new String[]{"HashMap internals", "heap versus stack", "class loading", "JVM memory areas", "concurrent collections", "synchronization internals", "deadlock prevention", "volatile and happens-before", "JIT compilation", "Java garbage collectors"});
            seedSubject(repository, "C++", "C++", "Easy", new String[]{"pointers", "references", "classes", "objects", "constructors", "destructors", "inheritance", "polymorphism", "templates", "STL"});
            seedSubject(repository, "C++", "C++", "Medium", new String[]{"pointer versus reference", "stack versus heap", "virtual functions", "copy constructor", "operator overloading", "smart pointers", "RAII", "STL vector", "STL map", "exception handling"});
            seedSubject(repository, "C++", "C++", "Hard", new String[]{"move semantics", "perfect forwarding", "rule of five", "virtual table", "multiple inheritance", "template metaprogramming", "memory ordering", "custom allocators", "lambda internals", "exception safety guarantees"});
            seedSubject(repository, "Python", "Python", "Easy", new String[]{"lists", "tuples", "sets", "dictionaries", "functions", "modules", "exceptions", "list comprehensions", "lambda functions", "classes"});
            seedSubject(repository, "Python", "Python", "Medium", new String[]{"decorators", "generators", "iterators", "shallow versus deep copy", "*args and **kwargs", "context managers", "mutable default arguments", "list versus tuple", "Python scopes", "virtual environments"});
            seedSubject(repository, "Python", "Python", "Hard", new String[]{"GIL", "asyncio event loop", "metaclasses", "descriptors", "MRO", "memory management", "generators internals", "multiprocessing versus threading", "performance profiling", "Python garbage collection"});
            seedSubject(repository, "C", "C Programming", "Easy", new String[]{"pointers", "arrays", "strings", "structures", "functions", "loops", "storage classes", "preprocessor", "dynamic memory", "header files"});
            seedSubject(repository, "C", "C Programming", "Medium", new String[]{"malloc versus calloc", "pointer arithmetic", "function pointers", "dangling pointers", "structures versus unions", "static versus dynamic memory", "const pointers", "recursion", "file handling", "memory leaks"});
            seedSubject(repository, "C", "C Programming", "Hard", new String[]{"undefined behavior", "volatile", "strict aliasing", "memory alignment", "custom allocators", "signal handling", "reentrant functions", "setjmp and longjmp", "linking process", "C memory model"});
            seedSubject(repository, "JavaScript", "JavaScript", "Easy", new String[]{"var, let and const", "== versus ===", "hoisting", "functions", "arrays", "objects", "JSON", "DOM", "events", "arrow functions"});
            seedSubject(repository, "JavaScript", "JavaScript", "Medium", new String[]{"closures", "promises", "async/await", "event loop", "this keyword", "prototype chain", "map/filter/reduce", "modules", "event delegation", "debouncing and throttling"});
            seedSubject(repository, "JavaScript", "JavaScript", "Hard", new String[]{"microtask queue", "prototype inheritance internals", "garbage collection", "memory leaks", "currying", "generators", "iterators", "service workers", "Web Workers", "JavaScript engine optimization"});
            seedSubject(repository, "SQL", "DBMS", "Easy", new String[]{"primary key", "foreign key", "WHERE clause", "ORDER BY", "GROUP BY", "HAVING", "NULL", "INSERT", "UPDATE", "DELETE"});
            seedSubject(repository, "SQL", "DBMS", "Medium", new String[]{"INNER JOIN", "LEFT JOIN", "UNION versus UNION ALL", "indexes", "subqueries", "second highest salary", "aggregate functions", "composite keys", "views", "transactions"});
            seedSubject(repository, "SQL", "DBMS", "Hard", new String[]{"window functions", "query optimization", "execution plans", "transaction isolation", "deadlocks", "clustered versus non-clustered indexes", "CTEs", "recursive queries", "partitioning", "database locking"});
            seedSubject(repository, "HTML", "Web Development", "Easy", new String[]{"semantic HTML", "div versus span", "forms", "headings", "links", "images", "lists", "tables", "HTML attributes", "DOCTYPE"});
            seedSubject(repository, "HTML", "Web Development", "Medium", new String[]{"id versus class", "accessibility", "meta viewport", "form validation", "data attributes", "iframe security", "HTML5 storage", "responsive images", "SEO-friendly markup", "ARIA labels"});
            seedSubject(repository, "HTML", "Web Development", "Hard", new String[]{"web accessibility architecture", "Content Security Policy", "HTML parsing", "preload versus prefetch", "custom elements", "shadow DOM", "structured data", "progressive enhancement", "critical rendering path", "cross-origin isolation"});
            seedSubject(repository, "CSS", "Web Development", "Easy", new String[]{"box model", "selectors", "specificity", "margin versus padding", "colors", "fonts", "display property", "position property", "Flexbox", "responsive design"});
            seedSubject(repository, "CSS", "Web Development", "Medium", new String[]{"CSS Grid", "Flexbox alignment", "relative versus absolute positioning", "media queries", "pseudo-classes", "pseudo-elements", "z-index", "transitions", "animations", "CSS variables"});
            seedSubject(repository, "CSS", "Web Development", "Hard", new String[]{"containing blocks", "stacking contexts", "layout performance", "container queries", "subgrid", "cascade layers", "BFC", "advanced Grid layout", "CSS architecture", "rendering optimization"});
            seedSubject(repository, "React", "Frontend", "Easy", new String[]{"React", "JSX", "components", "props", "useState", "event handling", "conditional rendering", "list rendering", "keys", "forms"});
            seedSubject(repository, "React", "Frontend", "Medium", new String[]{"useEffect", "controlled versus uncontrolled components", "useContext", "useRef", "lifting state", "custom hooks", "memoization", "React Router", "API fetching", "component composition"});
            seedSubject(repository, "React", "Frontend", "Hard", new String[]{"Virtual DOM", "reconciliation", "React.memo", "useMemo versus useCallback", "concurrent rendering", "Suspense", "error boundaries", "state architecture", "performance profiling", "server-side rendering"});
            seedSubject(repository, "Angular", "Frontend", "Easy", new String[]{"Angular", "components", "templates", "interpolation", "property binding", "event binding", "ngModel", "directives", "services", "modules"});
            seedSubject(repository, "Angular", "Frontend", "Medium", new String[]{"dependency injection", "routing", "lifecycle hooks", "reactive forms", "observables", "HttpClient", "pipes", "guards", "interceptors", "component communication"});
            seedSubject(repository, "Angular", "Frontend", "Hard", new String[]{"change detection", "OnPush strategy", "RxJS operators", "lazy loading", "route resolvers", "state management", "standalone components", "Angular rendering", "performance optimization", "custom structural directives"});
            seedSubject(repository, "Spring Boot", "Backend", "Easy", new String[]{"Spring Boot", "dependency injection", "@RestController", "@Service", "@Repository", "@GetMapping", "@PostMapping", "application.properties", "Spring Boot starters", "auto-configuration"});
            seedSubject(repository, "Spring Boot", "Backend", "Medium", new String[]{"Spring Data JPA", "constructor injection", "@ControllerAdvice", "@Transactional", "validation", "profiles", "REST exception handling", "JPA relationships", "pagination", "Spring Security basics"});
            seedSubject(repository, "Spring Boot", "Backend", "Hard", new String[]{"transaction propagation", "transaction isolation", "Spring Security filter chain", "caching", "Actuator", "custom auto-configuration", "JPA N+1 problem", "distributed transactions", "resilience patterns", "Spring Boot performance tuning"});
            seedSubject(repository, "DSA", "DSA", "Easy", new String[]{"largest array element", "reverse an array", "palindrome string", "linear search", "frequency counting", "stack operations", "queue operations", "linked list traversal", "array rotation", "two-sum basics"});
            seedSubject(repository, "DSA", "DSA", "Medium", new String[]{"binary search", "maximum subarray sum", "missing number", "duplicate detection", "merge intervals", "sliding window", "two pointers", "linked list reversal", "tree traversal", "heap operations"});
            seedSubject(repository, "DSA", "DSA", "Hard", new String[]{"longest substring without repeats", "cycle detection", "kth largest element", "LRU cache", "Dijkstra algorithm", "minimum spanning tree", "topological sort", "dynamic programming", "backtracking", "segment tree"});
            seedSubject(repository, "DBMS", "DBMS", "Easy", new String[]{"DBMS", "primary key", "candidate key", "composite key", "normalization", "foreign key", "tables", "constraints", "relationships", "schema"});
            seedSubject(repository, "DBMS", "DBMS", "Medium", new String[]{"1NF, 2NF and 3NF", "denormalization", "transactions", "views", "indexes", "joins", "ACID properties", "ER diagrams", "functional dependencies", "concurrency control"});
            seedSubject(repository, "DBMS", "DBMS", "Hard", new String[]{"serializability", "two-phase locking", "deadlock handling", "MVCC", "query optimization", "B-tree indexes", "distributed databases", "sharding", "replication", "recovery algorithms"});
            seedSubject(repository, "Operating System", "Operating System", "Easy", new String[]{"operating system", "process", "thread", "kernel", "system call", "file system", "CPU scheduling", "memory management", "virtual memory", "deadlock"});
            seedSubject(repository, "Operating System", "Operating System", "Medium", new String[]{"context switching", "paging", "segmentation", "page replacement", "process synchronization", "semaphores", "producer-consumer problem", "deadlock prevention", "scheduling algorithms", "inter-process communication"});
            seedSubject(repository, "Operating System", "Operating System", "Hard", new String[]{"deadlock detection", "Banker's algorithm", "thrashing", "working set model", "copy-on-write", "page fault handling", "multilevel feedback queue", "memory allocation strategies", "file system journaling", "kernel scheduling"});
            seedSubject(repository, "Computer Networks", "Computer Networks", "Easy", new String[]{"IP address", "DNS", "HTTP", "HTTPS", "TCP", "UDP", "router", "switch", "MAC address", "OSI model"});
            seedSubject(repository, "Computer Networks", "Computer Networks", "Medium", new String[]{"TCP versus UDP", "OSI layers", "TCP handshake", "subnetting", "ARP", "DHCP", "NAT", "routing", "congestion control", "HTTP methods"});
            seedSubject(repository, "Computer Networks", "Computer Networks", "Hard", new String[]{"TCP congestion algorithms", "TLS handshake", "BGP", "DNS resolution internals", "IPv6", "network security", "load balancing", "CDN architecture", "packet fragmentation", "HTTP/2 and HTTP/3"});
            seedSubject(repository, "OOP", "OOP", "Easy", new String[]{"encapsulation", "inheritance", "polymorphism", "abstraction", "class", "object", "constructor", "interface", "method", "access modifier"});
            seedSubject(repository, "OOP", "OOP", "Medium", new String[]{"composition versus inheritance", "method overriding", "method overloading", "interfaces", "abstract classes", "association", "aggregation", "dependency injection", "coupling", "cohesion"});
            seedSubject(repository, "OOP", "OOP", "Hard", new String[]{"SOLID principles", "dependency inversion", "Liskov substitution", "design patterns", "composition over inheritance", "open-closed principle", "interface segregation", "object immutability", "low coupling design", "domain modeling"});
            seedSubject(repository, "Git", "Git", "Easy", new String[]{"Git", "repository", "commit", "branch", "clone", "push", "pull", "fetch", "merge", "staging area"});
            seedSubject(repository, "Git", "Git", "Medium", new String[]{"merge conflicts", "rebase", "cherry-pick", "stash", "reset", "revert", "interactive rebase", "remote branches", "tags", "gitignore"});
            seedSubject(repository, "Git", "Git", "Hard", new String[]{"reset versus revert", "reflog", "bisect", "submodules", "worktrees", "history rewriting", "merge strategies", "hooks", "large repositories", "Git internals"});
            seedSubject(repository, "REST API", "Backend", "Easy", new String[]{"REST API", "GET", "POST", "PUT", "PATCH", "DELETE", "HTTP status codes", "JSON", "resources", "statelessness"});
            seedSubject(repository, "REST API", "Backend", "Medium", new String[]{"idempotency", "authentication", "authorization", "pagination", "filtering", "API versioning", "validation", "error responses", "rate limiting", "CORS"});
            seedSubject(repository, "REST API", "Backend", "Hard", new String[]{"OAuth2", "JWT security", "API gateway", "distributed tracing", "idempotency keys", "optimistic concurrency", "HATEOAS", "backward compatibility", "resilience patterns", "API security architecture"});

            long total = repository.count();
            System.out.println("========================================");
            System.out.println("QUESTION BANK UPDATED SUCCESSFULLY!");
            System.out.println("Expected managed questions: " + expectedManagedQuestions());
            System.out.println("Database total questions: " + total);
            System.out.println("========================================");
        };
    }

    private void seedSubject(
            QuestionRepository repository,
            String technology,
            String category,
            String difficulty,
            String[] topics) {

        for (String topic : topics) {
            String questionText = buildQuestion(technology, difficulty, topic);

            Question question = repository.findByQuestion(questionText)
                    .orElse(new Question());

            question.setCategory(category);
            question.setTechnology(technology);
            question.setDifficulty(difficulty);
            question.setQuestionType("THEORY");
            question.setQuestion(questionText);
            question.setHint(buildHint(technology, difficulty, topic));

            repository.save(question);
        }
    }

    private String buildQuestion(
            String technology,
            String difficulty,
            String topic) {

        if ("Easy".equals(difficulty)) {
            return "What is " + topic + " in " + technology + "?";
        }

        if ("Medium".equals(difficulty)) {
            return "Explain " + topic + " in " + technology + " with a practical example.";
        }

        return "Explain " + topic + " in " + technology
                + " in depth. Discuss how it works, important trade-offs, and common interview considerations.";
    }

    private String buildHint(
            String technology,
            String difficulty,
            String topic) {

        return "Give a clear " + difficulty.toLowerCase()
                + "-level explanation of " + topic + " in " + technology
                + " and include an example where appropriate.";
    }

    private int expectedManagedQuestions() {
        return 540;
    }
}