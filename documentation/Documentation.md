# Documentation of IsItSustainable

IsItSustainable is a website where users can find whether any type of organization is sustainable or not. Sustainability for organizations is subdivided into climate, people and animals. The data of the sustainability is user controlled and any type of organization can be added. On top of that, all sources of events regarding the sustainability of an organization can be traced and viewed. These are the essential differences between other sustainability websites. The way this whole system works and how it's maintainable is described in the chapters below

## TODO
- Make sure everything from core concepts is described here
- Some stuff should probably move to UX.md

## CHAPTERS
- 1. Elements
- 2. Layout
- 3. User Interaction
- 4. Data Validation
- 5. Calculations
- 6. Marketing

## 1. Elements
The main idea is to have 3 layers of elements. Organizations containing Events that have happened containing Sources that describe these events. Each seperate layer provide a different type of usefull information for the end user. Another important aspect of these layers is how they display the 'truth' factor of these sustainability of an organization.

### Levels of sustainability
For this application we define 3 levels of sustainability
- Climate
- Animals
- People

### Organization
An organization describes the most obvious element. Since we want to look up whether an organization is Sustainable or not. The data for this elements describes multiple aspects:
- Information regarding the Organization
- Which other Organizations the organization is partnered with, a child from or a parent to
- The relative global impact of the Organization as rated by users, with the amount of ratings
- A summary of (actually a calculation of) it's sustainability on the 3 sustainability levels. (gathered from data from the Events elements)
- Indicator which shows how reliable the ratings are (calculated as described in the Calcuations chapter)
- A list of Events for each sustainability level

### Events
An event describes a single event which an Organization (or multiple) have taken a part in. These can be small or large and their impact and sustainability can be rated by users.
As such an Event has the following properties:
- Information regarding the event
- Whether it's related to climate, animals or people
- The Organizations involved 
- Their average rated sustainability by users and the amount of ratings
- Their average rated impact by users and the amount of ratings
- A list of Sources for validation of the said event
- The reliability that the event really happened, calculated from the list of Sources

### Sources
Every event has a list of sources to validate whether this event is actually a real event belonging to an organization. These Sources are always shown with the events, so that the user can conduct their research as precisely as they want. Sources thus have two purposes: (in)validating or calculating the reliability of events and providing actuall background info regarding the said events:
- Their average rated reliability and the amount of ratings
- Information regarding a source
- Type of the source reference (papers, newspapers and other non-internet media should be referenceable as well)
- Links / identification of the source

These 3 types of sustainability and 3 types of building blocks provide the main logic of the applications data structure and navigation style.

## 2. Layout
The overall design of the website is as simple as possible. There's a simple header on top with a search bar and there's a list of Organization to scroll through.

#### Search (must,cannot,contains)
The search part is very important as people need to be able to look up any type of organization they want. For this every Organization has an unlimited amount of Tag's available. In this way the user can lookup tags instead of organization for sustainable shopping. For instance typing in the tag 'shoes' or 'softdrinks'. To provide the user with more control there are several niveaus of searching.

The first niveau only shows a singe search bar in which an Organization's name can be typed and the list of Organizations is updated with organization that contain the typed name.
The second niveau also shows Tag's and Location's for finding specific types of organizations from specific area's. This is to for instance reduce transport costs of ordered products, support local retailers and to look-up products only in specific categories ('shoes' or even 'shoes', 'leather', 'fashion' and 'women'). The final category gives the user full control of their search by providing the same search fields as in the second niveau but presented with 3 different types of logic. 'Must contain' means that ALL of the entered search queries MUST be matched, 'Contains' means that ANY of the entered search queries MUST be matched and finally 'Cannot contain' means that NONE of the entered search queries can be matched to display results.

Other search parameters that could be nice are:
- Sustainability ranges
- Global organization impact range
- Reliability range

### OrganizationList
An organization list displays a list of all / searched organizations. A single element of an OrganizationList, an OrganizationListElement has the following attributes;
- Name
- Tags
- Impact rating and num ratings
- Sustainability ratings and num ratings (for each category)
- Reliability ratings and num ratings
This view provides the end user the most quick and clear overview for comparing the sustainability of multiple organizations.

### Organization
This view displays as much info regarding a single organization as possible. This means this view also shows 3 EventsList for all sustainability types.

### EventsList
An EventsList shows all events of a single sustainability type for a single organization. In this view the user can examine what types of events the Organization participates in, how sustainable each event was and how believeable the event is. For best interaction a simple search field should also be provided. An even more usefull implementation would be to define a seperate event browser view, in which users can lookup events instead of Organizations in order to update those Events (for multiple organizations at once) and in order to find out which organizations are responsible for any trouble caused somewhere.

### Event
This view displays as much info regarding a single Event as possible. This also shows a SourceList containing all registered sources which describe this event.

### SourceList
A SourceList shows a list of all sources for a single Event. Each source is displayed with their name, source type and credibility rating.

### Source
This view displays information on a single source as compressed and complete as possible. Providing the user a way to lookup the source for themselves.

## 3. User Interaction (UX)
A whole different aspect of this application is how a user would actually interact with this system, looking at the amount of options available.

### Adding / Rating / Updating Elements
For adding, rating and updating elements, a seperate view is provided. This can be implemented in a multiple ways; A seperate website for this extended purpose or a simple toggle could enable an edit view. For reducing bot activity captchas, ipadress logging systems or account registration can be used. Actual additions and updates can be maintained and checked, this system is described in chapter 4.

### Searching through Elements
The most important feature is the search features. It should be as easy as possible for users to find out;
- Whether something is sustainable
- Why something is or isn't sustainable
- What alternatives there are
- How someone can shop/live in a sustainable way

## 4. Data validation
There are three forms of data which users can submit: Ratings, Additions and Updates. There are a few main ways in which this data is / can be validated, but validation is the most tricky part of this whole concept, so iterative design must be implemented / expected. While a part of validation is handled by clever calculations, as , the first line of control is provided by man-driven processes play such as:
- Linking data submissions to actual people (IDN, google/facebook, accounts, ipadress)
- Verifying additions and updates by journalists before updating the actuall data.

### Admin view / Approval view
For verification of entered data, (professional) neutral (journalists) people must manually go through all entered info and mark each update or addition as approved or denied. While this seems like a tiresome and timeconsuming process, this is a lot less work then actually researching, looking up, entering and submitting all data. The whole general idea of user controlled submission is that more total information regarding Organizations worldwide will be stored. This makes the application futureproof and investment worthy.

In order to provide this approval process a seperate front-end is required. A secret link and/or loggin system can be used to verify the identity of the approver and the approver will then only see a long list of all new additions and updates. For the approver the task then becomes as simple as opening an update or addition and clicking on either approve or deny. Of course in case the website blows up, this view can be improved to support larger scale work where more approvers are involved, but I think it's to early in the process to overthink that, from an iterative perspective. Wikipedia's system can help as an inspiration of how this could actually be implemented. 

## 5. Calcuations for data representation
In order to properly present all data, some smart calculations must be made and I'll explain why. If an Event has a very positive rating, but not a single Source, it's should be counted much towards the Organization's sustainability rating. Another example: If an Event has a lot of Sources, each with a different reliability and with different amounts of reliability ratings the total reliability score should be calculated for the Event. These calculations are crucial and defining for the results which are shown to the end user.

### Example: calculating Global impact
Each organization of course has a different amount of impact on the world. An organization can be neutral in sustainability but can be large, in that case it would perform pretty well for a large organization. At the same time an organization can be small and have a very negative sustainability rating. This would be more alright, since small companies don't have such a large footprint (this part is arguable of course, but they idea of the calculation stands). For an end user this is important because he/she might be interested in looking for the biggest poluters or the most sustainable startups. 

As a starting point in this application we've chosen to add user ratings for the global impact of organizations. The suggested algorithm can be found here: 
[Technical_Design](Technical_Design.md)

## 6. Marketing/Release
- Video presentation that explaines the concept to people and would be useable for vloggers and social media
- Donation option bottom right corner

