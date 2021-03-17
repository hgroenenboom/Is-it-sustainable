# UX overview

In this document we list information regarding the UX of this project:
1. Features
2. Ideas
3. Issues
4. Discussion
5. Components

## TODO
- Manage features with MoSCoW model
- Create wireframes for components, for instance in figma

## 1. Features
- Possible to view all denied elements
- Specific update-request view for admins to select which elements from an update-request to use for the update
- Mark anything for review
- Everything should be sorteable
- Embedding badge for websites to display their sustainability
- Top 100 sustainabile companies to stimulates companies with their status on the site as a commercial strength
- View element history to see what admins do with the data

## 2. Ideas
- Add cities to OrganizationLocation so people can search for sustainable companies in the city they are in or are visiting. 
    > How to we do this technically? What is the best way to save the location range and be able to search by different location types as well (regional, international etc.)
    
## 3. Issues
- Website doesn't take framing into account, what if a certain company is nitpicked for something bad that once happened but now doesn't do anything bad anymore?
- Are the people involved in this project in possible danger from companies?

## 4. Discussion

### SourceRating
- Should ```reputable``` and ```effect``` be simple interactions such as a up or downvote, or should user be able to specify the amount of reputability and effect? 

## 5. Components
## Components / Layout

### Three main views:

#### 1. Anonymous view
*TODO*
#### 2. User view. 
Possible to lookup companies and sources regarding their sustainability and to vote for the reputation and effect of a source.
This would have login options to create more safety for the Database

Header
- Browse
- Top 1000 worst link
- Top 1000 sustainable link
- Search bar
    - advanced search toggle
        1. Must have
        2. Cannot have
        3. Has any of
- About link
- Edit toggle: Adds 'update' & 'add' buttons to all fields (L)

Browse: 
- Organization list (sortable)

#### 3. Admin view. 
In this view admins can edit & approve or deny source updates and submissions as well as organization updates and submissions.
This should also have a very secure sign-in system to avoid data corruption

Header (same as *2* <b>except</b> without the 'Edit toggle')

Search view:
- Table of <b>added</b> organization
    With admin functions
    - Edit submission 
    - Remove submission
    - Approve submission
    - Consolidate with other submission
- Table of <b>updated</b> organization
    Also with admin functions
- Organization list (sortable)

### Components

#### Organization list-element
- name
- calculated reputation
- calculated impact
	- 3 subimpacts for climate, animals and people
- partners tags (with hyperlink)
- locations tags (with hyperlink)
- tags (with hyperlink?)

#### Organization
> everything from 'Organization listcomponent'
- website
- 3 'Sourcelist component's
	- climate
	- animals
	- people

#### Sourcelist component
*TODO*