# UniBookClub
# Weekly Report: Book Club App

## 10-11-2024

### Challenges:
- The biggest challenge I faced in the beginning of this development was getting feedback from students. While I already had the basics decided upon (home, registration, and login), I then had to find other students that would be interested in a book club app.
- I had to ensure consistency across the pages. Where a text font suited one page, it didn’t quite feel like it fit all the pages. As I tried to adhere to more accessible methods, I needed to implement what I had learned throughout my education. This meant using sans-serif fonts rather than serif fonts, as sans-serif fonts are easier to read by computers.

### Decisions:
- The decisions I faced came in the form of things like feature prioritization. Based on student feedback, I decided to stick to simplicity in that there would be:
  - An **Events** page to let people know where and when meetings would take place.
  - A **polling page** where students can vote on what books they would like to discuss next.
- The decision to use the **Atomic Design** approach helped in that it made reusability of components and templates more convenient. Rather than needing to remake a form multiple times, this approach will help in the future if I need it again.

### Lessons Learned:
- It was useful to gain early user input so that I could develop an app that will be useful to other students and include features that students will interact with.
- I will be utilizing interactive testing throughout the development of this app as I have found the use of **Agile methodology** to be very useful in the past for developing something users will genuinely appreciate.
- I’ve learned how useful **Atomic Design** is in that it will make things easier in further development so that I will not need to remake different components and templates.

---

## 17-11-2024

### Challenges:
- This week my biggest challenges faced were in implementing the **Room Database** and **Firebase** into my project.
- Another challenge was finding the best way to import my **Figma wireframes** for this project into a coded layout for a quicker, more efficient use of time.

### Decisions:
- One decision made was that I would allow users to add their own events to the **Events** page table. I felt that in a real-world setting it would be easier this way for the admins if users could input their own meet-up events, rather than having people email and needing to approve entries in a short time period. This way, it would work somewhat similar to a forum.

### Lessons Learned:
- This week I learned how to implement **Builder.io**, which made converting my Figma wireframes to code very quick and easy.
- I have used **GitHub branches** so that I can work on different aspects of the project before putting them all together. This way, I can also keep track of the changes I’ve made along the way, and it will make it easier to go back and fix any mistakes or issues later on. It also helps in that it will not affect the overall project that remains in the **Main Branch**. This week, I have been working on my branch labeled **‘Room Database’**, in which I am working from a previous lab to set up the Room Database, and will later on implement it into the overall project in the matching style.

---

## 24-11-2024

### Challenges:
- This week my biggest challenge has been getting the **Room Database** operational.
- I have utilized components made for the **header**, **footer**, **login**, and **registration form**. Using components, I have found that the development of this app runs a lot smoother. Rather than having the same code copied and pasted across multiple pages (resulting in hundreds of lines of coding), I can simply call each component onto the page with a simple `Header()`, `Footer()`, `RegistrationForm()`, or `LoginForm()`.

### Progress:
- While I have my **Login function** working and connected to Firebase, I still need to get the Room Database working. However, I feel that as I have my navigation and Firebase login working satisfactorily, I will be able to get the Room Database operational within the next week.

---

## 02-12-2024

### Changes:
- I have made changes to the overall app to secure access by making the starting point/entry point the **login page**. On this page, I have added an option for **Login** or **Register**. Upon clicking the submission/Login button, depending on the page, the user is then brought to the **Home Page**. From there, they can access:
  - An **events page** labeled **Meet Ups**, which will display a list of book club meet-ups.
  - A **Polling page**, where users can have their say on the next book to be discussed at the meeting. There is also an option for users to add their own suggestion to the polling section.

### Implementation:
- I have implemented **Firebase** to store **Registration details**. Details of users’ email and passwords will be stored on the Firebase database system and therefore used for secure login purposes. This has been tested by a couple of students for effectiveness.
