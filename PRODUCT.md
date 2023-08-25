# NiheApp
NI-HE PRODUCT REQUIREMENT DOCUMENT

Introduction
Humans are social creatures. This means that we inherently need to interact with each
other on a day-to-day basis in order to feel valued and have a sense of belonging. This is
why it appears that we can never have too much social media. Another thing that we as
humans are inherently inclined toward is consumption. The average individual spends more
than 70% of their income on consumer goods that can be purchased online. Due to this,
there has been a rise in what is known as "social commerce." which is a bridge between a
social media platform and an e-commerce platform. The social media commerce market
capitalization is around $500 billion in 2021. It is expected to grow up to $3500+ billion in
the next 5-7 years globally. It is on this premise of the human need to socialize and
consume that NiHe is built.
Problem
Though there has been a rise in social commerce with platforms like Facebook and
Instagram somewhat taking the lead in this market. These platforms have one big issue that
creates a market for the solution we are trying to build. This problem is that these
platforms are not primarily built with businesses in mind. This means that these platforms
are essentially social media platforms that enable sales. And so, although people buy via
these platforms they do not primarily go there to buy, and so new businesses can't really
thrive there without spending a ton in ads. This is where Nihe comes in.
About Nihe
Nihe is a social e-commerce platform, the first of its kind in Africa, built to fulfill the human
need to socialize and consume in almost equal portions. Nihe is built primarily to bridge the
gap between businesses and people, businesses and businesses, people and businesses,
people and people. And because it is built in that way, it becomes a global community of
people who socialize and buy from each other. The picture is of an African market where
friends from different communities meet in a central place to catch up and buy from each
other during market days.

Goals and Objective
- to be the foremost social e-commerce platform in Africa and beyond

- To connect people who run businesses across africa with friends, and family who
  want to buy.
  Target Audience
- Men and women of african descent living in Africa
- Between the ages of 14 - 65 years.
- Who are digitally savvy
- Who wants to buy or sell online as well as socialize
  Success Criteria
  A mobile-responsive and user-friendly web app that allows its users to achieve our
  objectives flawlessly.
  IN SCOPE

EPICS FEATURES
User Authentication Authentication
- Register
- Log in
- Reset password
- Log out
  User Interaction Upload media content

- Create and share own content
- Allow others to interact with shared
  content
- Create dynamic content
  User timeline
- See content from friend and
  community on platform
- See own activity on the platform
- Interact with content on platform
  (react, comment, share)
  Notification
- Receive update on content shared
- Receive platform related content
  Friend List
- View friend requests
- Search for friends
- See suggested friends
- See friends list
- Add friend

User profile
- Create profile
- CRUD profile
- View your activities on the platform
- Link other social media platforms to
  the platform

OUT OF SCOPE
Anything that is not in the current MVP is out of scope.

EPIC: User Interaction

Feature 002 Upload media content
Description upload and posting of text and media content on the platform.
User Stories - As a user, I want to be able to upload text, picture, and video

content.
- As a user, I want to be able to share media content created by
  others.
- As a user, I want to be able to CRUD the content I upload.
- As a user, I want people who see my content to be able to react
  with a laugh or like emoji to the content I have shared.
- As a user, I want people who see my content to be able to
  comment on the content I have shared.
- As a user, I want to be able to further express myself using the
  different available emojis when I am creating content.

Acceptance
Criteria

- A user should be able to interact with the shared content on the
  platform as stated in the user story.
- A user should be able to create and share all forms of content on
  the platform.

Non
Functional
Requirement

Performance: Uploads larger than (25 MB) should be compressed to 25
MB, and if they are not able to be compressed, they should be rejected
(The size limit can be altered).
- Flagged content should be pulled down within 2 mins.

Business rule Content promoting violence, sexual misconduct, or undermining another

business on the platform should be flagged down.

Feature 003 User timeline
Description the viewing and display of user’s content on the platform
User Stories - As a user, I want to be able to see the content shared on the
platform from my friends, and the platform’s community
members.
- As a user, I want my friends content to be given priority on my
  timeline.
- As a user, I want to be able to react with the laugh and/or like
  emoji on the content I see on my timeline
- As a user I want to be able to comment on the content displayed
  on my timeline
- As a user I want to be able to endlessly scroll through my timeline
  without having to go to another page to see more.
- As a user, I want to be able to have the option to see the profile of
  the people who shared the content I see on my timeline.
- As a user, I want to be able to have the option to see the profile of
  the people interacting with content and sharing content on my
  timeline, so that I can have the option to add them as my friends.
- As a user, I want to be able to share the content I see from other
  users on the platform to my timeline.

Acceptance
Criteria

- Priority should be given to showing content shared by friends and
  friends of friends of the user.
- A user should be able to interact with the shared content on the
  platform as stated in the user story.
- There should be no break in the showing of content on user
  timeline, unless the user interrupts the flow.

Non
Functional
Requirement

Performance: Uploads larger than (25 MB) should be compressed to 25
MB, and if they are not able to be compressed, they should be rejected
(the size limit can be altered).
- Flagged content should be pulled down within 2 mins.
  Business rule Content promoting violence, sexual misconduct, or undermining
  another business on the platform should be flagged down.

Feature 004 Recieve Notification

Description Updates on platform activities
User Stories - As a user, I want to be able to receive updates on every action

taking on the content I shared.
- As a user, I want to be able to receive updates on every content I
  have taken action on.
- As a user, I want to be able to receive notifications about updates
  to the platform.

Acceptance
Criteria

User should be able to receive selected types of notification as detailed
above

Feature 005 User profile
Description User is able to see a summary of their overall activity on the platform

based on a view metrics

User Stories - As a user I want to be able to create my profile using the following

information;
- Username
- First name
- Last name
- Email
- Phone number
- State
- Country
- Address
- As a user, I want to be able to CRUD my profile information
- As a user, I want to be able to see number of comments I have
  made on the platform
- As a user, I want to be able to see the number of posts I have made
  on the platform
- As a user I want to be able to see my image, name, and username
  when I am vieing my activity on the platform.

Acceptance
Criteria

The user should be able to create their profile and do all the functions
listed above.

Non
functional
Requirement

Performance: Users should only be allowed to change their usernames
once every 7 days.

Business Rule - Usernames must be fewer than 15 characters in length and cannot

contain "admin" or "Ni-he" “Nihe” “nihe” “ni_he” or any
combination of those two words in order to avoid brand confusion

Feature 006 Friends list
Description A holistic way to grow the user's friend circle on the platform.
User Stories - As a user, I want to be able to see all friend requests I have received,

which have not been accepted.
- As a user, I want to be able to see suggestions of people I could add
  to my ffriend’s list
- As a user, I want to be able to see the newest people in my friends’s
  list.
- As a user, I want to be able to see the profile of the people shown to
  me whether new, suggested or requested friends.
- As a user, I want to be able to see a message indicating that I have
  no new friend request when I don’t have any new friend request.
- As a user I want to be able to search for new friends using their
  names.
- As a user, I want to be able to send friend request to people on the
  platform.

Acceptance
Criteria

The user should be able to see friend lists as stated above.