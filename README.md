# Rest API with Swagger![image](https://user-images.githubusercontent.com/103988427/169981197-3e7cefda-592c-499e-96d6-285b488f5eec.png)
# រៀនតាមរយះ Source Code នៅក្នុង Github Branches Repository: 
- Source Code គឺមានទៅតាម *Branches* នីមួយៗទៅតាមមេរៀន ដូច្នេះអ្នកអាចរើសតាម *Branches* បាន!![image](https://user-images.githubusercontent.com/103988427/169982053-58784fed-a416-48bb-9f64-d67b7eac1ddc.png)
# ជំនួយបន្ថែម : 
- ដើម្បីរៀនតាម Tutorial មួយនេះឲ្យកាន់តែឆាប់យល់ ឆាប់ចាប់បាន អ្នកគួរមើលវីដេអូ Springboot Crush Course ខ្លះៗដែរ ដើម្បីជាជំនួយក្នុងការសិក្សាវាបន្ថែម។ 
> Spring Boot Tutorial | Full Course [2021] [NEW] by Amigoscode <a href="https://www.youtube.com/watch?v=9SGDpanrc8U">![springboot-amigoscode](https://user-images.githubusercontent.com/103988427/169996333-01640549-e304-406e-a837-cb846a37c161.jpg)</a>
# បញ្ចាក់ : 
- វីដេអូខាងលើមួយនេះ គឺផ្តោតទៅលើការប្រើប្រាស់ Springboot ជាមួយ Java ដូច្នេះអ្នកអាចរៀនពីការប្រើ Springboot នៅក្នុង Tutorial មួយនេះបាន។
# តម្រូវការមុននឹងសិក្សា Springboot : 
- មុននឹងអ្នកអាចរៀននឹង Springboot បាន អ្នកត្រូវមានចំណេះដឹងទាក់ទងនឹងភាសា Spring ជាមុនសិន។ ហើយអ្នកក៏គួរតែមានចំណេះដឹងទាក់ទងនឹងផ្នែក Frontend(HTML, CSS, JavaScript) ផងដែរ ព្រោះ Spring ជាភាសាដែលយើងយកវាមកប្រើនៅក្នុងផ្នែក Backend។
# អ្វីទៅជា Springboot?
- **Springboot** ជាការ Bootstraping នូវ Project របស់ Spring ហើយ Spring គឺជា framework របស់ភាសា Java ដែលប្រើសម្រាប់សរសេរកូដបង្កើតជា Web Application ។
# ចំណុចពិសេសរបស់ Springboot
- **Core technologies** មានដូចជា dependency injection, events, resources, i18n, validation, data binding, type conversion, SpEL, AOP ។
- **Spring MVC – MVC** គឺជា Model View Controller។ Model យើងប្រើសម្រាប់បង្កើតជា Table នៅក្នុង Database ហើយមានទំនាក់ទំនងជាមួយ Database ច្រើន រីឯ View វិញគឺដូចទៅនឹងការរចនាគេហទំព័រដោយការសរសេរកូដ HTML, CSS និង JavaScript ចឹង រីឯ Controller គឺប្រើសម្រាប់បង្កើតទំនាក់ទំនងរវាងនឹង Model នឹង View គឺមានន័យថាធ្វើឲ្យ Server មានទំនាក់ទំនងជាមួយ Client ។
- **Hibernate & JPA** គឺជាលក្ខណះពិសេសរបស់ភាសា Java ដែលផ្តល់នូវមុខងារជាក់លាក់មួយ និងផ្តល់លក្ខណះស្តង់ដារទៅ ORM(Object Relational Mapping ជាឧបករណ៍ដែលផ្តល់លក្ខណះសាមញ្ញទៅឲ្យការបង្កើតទិន្នន័យ, រៀបចំទិន្នន័យនិងដំណើរការទិន្នន័យ បើនិយាយក្នុងន័យកូដគឺវាជាបច្ចេកទេសក្នុងការសរសេរកូដដើម្បីបង្រួមគ្នារវាង Object និង Data Store បញ្ជូលគ្នាទៅក្នុងប្រព័ន្ធទិន្នន័យ)។
- **Spring Security** ជា framework នៅក្នុងភាសា Spring ដែលប្រើសម្រាប់ត្រួតពិនិត្យ authentication និង authorization ។
## តើធ្វើយ៉ាងមិចបានអាចសរសេរ Springboot បាន?
- ត្រូវចំណាំថា ដើម្បីសរសេរ Springboot បានយើងត្រូវការបង្កើត Project របស់ Springboot ដោយចូលទៅក្នុងគេហទំព័ររបស់ Spring គឺ https://start.spring.io/ ឬក៏ចូលទៅកាន់ IDE របស់អ្នក តែយល់ល្អ គួរតែចូលតាមគេហទំព័រដែលមានតំណរលីងខាងលើទៅ។ តែមុននឹងបង្កើត Project យើងត្រូវទាញយកនូវ Java Development Kit សិនដែលគេគ្រប់គ្នាហៅថា JDK មកក្នុងកុំព្យូទ័ររបស់អ្នកសិន: https://www.oracle.com/java/technologies/javase-downloads.html ហើយធ្វើការជ្រើសរើស version ណាដែរអ្នកចង់ប្រើ សម្រាប់ tutorial មួយនេះគឺពួកយើងប្រើ version 11 ចឹងអ្នកអាចប្រើ version នេះតាមពួកយើងបាន។
- តោះទៅបង្កើត Project Springboot ទាំងអស់គ្នា!![start-spring-io](https://user-images.githubusercontent.com/103988427/169998016-e66b8306-633b-4af9-bd30-b34973bac225.jpg)
- សម្រាប់ Project គឺពួកយើងជ្រើសយក Grandle Project ចំណែកឯ Language គឺយកភាសា​ Kotlin ហើយ Springboot គឺយក version ចុងក្រោយគេ។ សម្រាប់ Group, Artifact, Name, Description, និង Package name គឺដាក់តាមអ្វីដែលចង់ដាក់នឹងគ្រប់គ្រង។ សម្រាប់ Packaging គឺពួកយើងយកប្រភេទ Jar ហើយសម្រាប់ Java គឺយកទៅតាម version JDK ដែលអ្នកបានទាញយកកន្លងមក។
- ក្រឡេកភ្នែករបស់អ្នកមកមើលខាងស្តាំដៃបន្តិចគឺឃើញថា Dependencies ដែលក្នុងនោះគឺត្រូវយក Spring Web ដែលប្រើសម្រាប់បង្កើតជា REST API ហើយមួយទៀតគឺ Spring Data JPA ដែលប្រើសម្រាប់បង្កើត Table តាមរយះ ORM និងមួយទៀតគឺ H2 Database ដែលជា Memory Database ។
- បន្ទាប់មកចុចប៊ូតុង Generate នៅខាងក្រោមដើម្បីទាញយក Project នោះមកលើកុំព្យូទ័ររបស់អ្នក។
