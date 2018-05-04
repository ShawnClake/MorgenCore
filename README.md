# MorgenCore
#### Java library full of misc java functions for use in projects, prototyping, and efficient development

#### Release 1 due 2019

## Lingo
|    Name   |                                       Summary                                       |         | Depends |           |
|:---------:|:-----------------------------------------------------------------------------------:|:-------:|:-------:|:---------:|
|     -     |                                          -                                          | Feature |  Module | Component |
|  Feature  | Opinionated Frameworks for developing core functionalities in complex applications  |    ✔    |    ✔    |     ✔     |
|   Module  |    Tools which assist in the creation of custom features in complex applications    |    ✘    |    ✘    |     ✔     |
| Component |          Low Level utilities which abstract away verbose and skeletal code          |    ✘    |    ✘    |     ✘     |

## Implemented (As of April 2018)
* Vectors - 35%
    * Still needs matrix calculation support
    * 1D, 2D, 3D, and some helper utilities
* Symbols - Requires Refactoring
* Strings - 40%
    * Needs additional helper methods to fill out the class
* Results - 70%
    * Methods need renaming
    * Better commenting
    * Move methods to better places
* Properties - Needs refactor
    * Needs to extend AdvancedObject
* RegexResult - Needs Refactor
    * Needs to extend Results
    * Needs commenting/better variable naming
* Priority - Needs refactor
    * Needs to extend AdvancedEnum in order to extend
* Numbers - 60%
    * Needs more helper methods to fill out the class
    * Needs better variable naming
    * Needs more robust documentation
* MetaData - 85%
    * Needs more robust documentation
* Mail - 1%
    * Needs implementation
* Helpers - Needs Removal
* Terminal - 10%
    * Needs far more helper methods for terminal IO
    * Center text, print lists etc.
* Services - 90%
    * Needs to utilize the new Observer pattern
    * Services needs far more documentation and better method naming
* Reflection - 40%
    * Needs more helper methods
* Objects - 60%
    * PrimitiveConverter needs more documentation and exceptions when conversion fails
    * Some of the advanced primitives still need implementations
* Libraries - 50%
    * More documentation
    * More library types
* FileSystem - Needs Refactor
* DB - 55%
    * Needs more query builder
    * Needs more documentation
    * Needs better class naming
* Crypto - 10%
    * Needs more supported algorithms
    * Needs a consistent interface for encrypting/decrypting
* Collections - 10%
    * Needs far more implementation


## Planned Packages (As of 2017)
|       Core      |   Core Services  |    Network    |     System    | User Interface |  Integrations |
|:---------------:|:----------------:|:-------------:|:-------------:|:--------------:|:-------------:|
|     Account     | Database Service | Communication | Configuration |  UserInterface |    Discord    |
|     Commands    | Recipies Service |    Realtime   |       IO      |    Graphics    | Interactables |
|    Inventory    | UserData Service |  Distributed  |      AHM      |     Buffer     |     Stocks    |
|     Cooldown    |  Logging Service |   Connector   |      File     |   Pagination   |    Currency   |
| Granular Ticker |  System Service  |     AppAPI    |   Directory   |                |    Facebook   |
|       CRUD      |  Buffer Service  |   WebSockets  |    Logging    |                |     Google    |
|      Clone      |                  |     Packet    |     System    |                |     Steam     |
|     Database    |                  |   Networking  |               |                |    Twitter    |
|    Reflection   |                  |               |               |                |               |
|     Services    |                  |               |               |                |               |
|      Crypto     |                  |               |               |                |               |
|      Costs      |                  |               |               |                |               |
|     Recipies    |                  |               |               |                |               |
|    Properties   |                  |               |               |                |               |
|     UserData    |                  |               |               |                |               |
|     Messages    |                  |               |               |                |               |
|      Events     |                  |               |               |                |               |
|     Threaded    |                  |               |               |                |               |
|        AI       |                  |               |               |                |               |

## Dependencies
|    Package   |         Dependency        |                          Link                         |               Justification              |
|:------------:|:-------------------------:|:-----------------------------------------------------:|:----------------------------------------:|
|     Core     |           SQL2o           |                 https://www.sql2o.org/                |        Legacy SQL. Less Overhead.        |
|              |            jOOQ           |                  http://www.jooq.org                  |     Modern SQL w/ DSL. More Overhead.    |
|              |          Jackson          |          https://github.com/FasterXML/jackson         |               File parsing               |
|              | Jackson Data Text Formats | https://github.com/FasterXML/jackson-dataformats-text |               Supports YAML              |
|              |        Documents 4j       |               http://documents4j.com/#/               |              File conversion             |
|              |      Deep Learning 4j     |         https://deeplearning4j.org/quickstart         |           Neural Network for AI          |
|    Network   |           Netty           |                   https://netty.io/                   | Low level standardized network functions |
|              |        Rest Express       |  https://github.com/RestExpress/RestExpress-Archetype |         Rest API on top of Netty         |
| Integrations |            JDA            |         https://github.com/DV8FromTheWorld/JDA        |          Discord API Abstraction         |

## Features
- Coming Soon

## Planned Features
- Communication (Packet, Services, Database) ~2018
    - P2P
    - Centralized
- Realtime (WebSockets, Packet, Services, Database, Communication) ~2019
    - P2P
    - Centralized
- Distributed (Messages, Events, Services, Database, System, Realtime, AHM, Connector) ~2021
    - Node Inventory
    - High Availability
    - Director/Controller
    - Client/Server Software for maintaining a connection
- UserInterface (IO, Graphics) ~2020

## Modules
- Connector Server (Events, Database, Threaded)
- Account (Crypto, Events, Database, Services)
- Discord (Database, Messages, Events)
- Commands (Messages, Events, Database, Services)
- Configuration (File Interactions, Directory Interactions, Services)
- Interactables (Events, Services)
- Inventory (Events, UserData, Services)
- Cooldown (Events, Services)

## Planned Modules
- Stock Market (Events, Messages, Database, Threaded, Services) ~2019
    - View realtime stock market evaluations
    - Create artificial stocks local to the application
- Currency (Events, Messages, Database, Threaded, Services) ~2019
    - View realtime currency exchanges
    - Compute an exchange
    - Create artifical currencies local to the application
- Facebook Accounts (Events, Database, Services) ~2018
- Google Accounts (Events, Database, Services) ~2018
- Steam Accounts (Events, Database, Services) ~2018
- Twitter Accounts (Events, Database, Services) ~2019
- IO (Buffer, Events, Messages) ~2018
- AppAPI (Events, HTTP, Services, Database) ~2019
    - REST API endpoints
- WebSockets (Events, HTTP, Services, Database, Messages, Threaded) ~2019
    - Pusher
    - Manual Socket Server/Client
- Granular Ticker (Events, Threaded) ~2018
- AHM: Application Health Monitoring (Messages, Events, Services, Database, System, Threaded) ~2020
    - Periodic checks of chosen states in the application to show as health
- CRUD (Database, Threaded) ~2018
- Graphics (Buffer, Events) ~2019
    - 2D UI Buffer
    - Auto-Sizing Grid-ing
- Packet (Events, Buffer, Networking, Messages) ~2018

## Components
- Clone 
- Database
- Reflection
- Services
- Crypto
- Costs
- Recipies
- Properties
- UserData
    - Volatile UserData
    - Persistent UserData
- Messages

## Planned Components
- Events ~2017
- Threaded ~2018
    - Tasks
        - Repeatable
        - Delayed
        - One use
- File Interactions ~2018
    - YAML, CSV, Text, PDF, Audio, Video
    - Create, Initialize with defaults, read, copy, update, delete
    - Database tracking
    - Versioning
    - Comments where appplicable
- Directory Interactions ~2018
    - Create, List, Recursive, Move, Delete, Find/Search, Filters
- Buffer ~2018
    - 2D
    - 3D
    - Scrollable
    - Sizable
    - Generic
- Pagination ~2018
- Logging ~2017
- AI ~2020
- Networking ~2018
    - HTTP
    - Netty
    - TCP/UDP
- System ~2017
    - System level commands and scripts
    - Ansible interface
    - Bash interface
