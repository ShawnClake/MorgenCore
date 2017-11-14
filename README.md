# MorgenCore
#### Java library full of misc java functions for use in projects, prototyping, and efficient development

## Lingo
|    Name   |                                       Summary                                       |         | Depends |           |
|:---------:|:-----------------------------------------------------------------------------------:|:-------:|:-------:|:---------:|
|     -     |                                          -                                          | Feature |  Module | Component |
|  Feature  | Opinionated Frameworks for developing core functionalities in complex applications  |    ✔    |    ✔    |     ✔     |
|   Module  |    Tools which assist in the creation of custom features in complex applications    |    ✘    |    ✘    |     ✔     |
| Component |          Low Level utilities which abstract away verbose and skeletal code          |    ✘    |    ✘    |     ✘     |

## Features
- Coming Soon

## Planned Features
- Communication
    - P2P
    - Centralized
- Realtime (WebSockets, Packet, Services, Database, Communication)
    - P2P
    - Centralized
- Distributed (Messages, Events, Services, Database, System, Realtime, AHM, Connector)
    - Node Inventory
    - High Availability
    - Director/Controller
    - Client/Server Software for maintaining a connection
- UserInterface (IO, Graphics)

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
- Stock Market (Events, Messages, Database, Threaded, Services)
    - View realtime stock market evaluations
    - Create artificial stocks local to the application
- Currency (Events, Messages, Database, Threaded, Services)
    - View realtime currency exchanges
    - Compute an exchange
    - Create artifical currencies local to the application
- Facebook Accounts (Events, Database, Services)
- Google Accounts (Events, Database, Services)
- Steam Accounts (Events, Database, Services)
- Twitter Accounts (Events, Database, Services)
- IO (Buffer, Events)
- AppAPI (Events, HTTP, Services, Database)
    - REST API endpoints
- WebSockets (Events, HTTP, Services, Database, Messages, Threaded)
    - Pusher
    - Manual Socket Server/Client
- Granular Ticker (Events, Threaded)
- AHM: Application Health Monitoring (Messages, Events, Services, Database, System, Threaded)
    - Periodic checks of chosen states in the application to show as health
- CRUD (Database, Threaded)
- Graphics (Buffer, Events)
    - 2D UI Buffer
    - Auto-Sizing Grid-ing
- Packet (Events, Buffer, Networking, Messages)

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
- Events
- Threaded
    - Tasks
        - Repeatable
        - Delayed
        - One use
- File Interactions
    - YAML, CSV, Text, PDF, Audio, Video
    - Create, Initialize with defaults, read, copy, update, delete
    - Database tracking
    - Versioning
    - Comments where appplicable
- Directory Interactions
    - Create, List, Recursive, Move, Delete, Find/Search, Filters
- Buffer
    - 2D
    - 3D
    - Scrollable
    - Sizable
    - Generic
- Pagination
- Logging
- AI
- Networking
    - HTTP
    - Netty
    - TCP/UDP
- System
    - System level commands and scripts
    - Ansible interface
    - Bash interface
