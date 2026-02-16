# KWFM Container Diagram Diagram

|               |                                  |
| ------------- | -------------------------------- |
| `Participant` | Márcio Alexandre Freire Sindeaux |
| `Date`        | 16/02/2026                       |

## 1.Document purpose

This document have the purpouse to show the container diagram for the software system [Kotlin Web File Manager System](../KWFM%20Context%20Diagram.md).It now shows the software "to be", but the purpose is to show what the software really is. This file is not a static file but a liveness documentation to aways shows what the software is and what want to be.

## 2.Diagram Context

<br>
<div align="center">

![](./static/container_diagram.png)

</div>
<br>

## 3.Container Elements

### Interfaces

- Mobile App (To be)
- Web Browser (Priority)

### Gateways

- Api Gateway: The gateway is responsible for encapsulating all API calls, ensuring that the APIs are not exposed. It also functions as a BFF (Backend for Frontend).

### Microsservices

- User Manager Service: Service responsible for managing the insertion and retrieval of data from registered users.
- Auth Service: Service Responsible for registre any attempt to log-in into any account.
- Storage Metadata Service: This service is responsible to manage and update the references for folders and files
- Storage Query Service: Service responsible for search metadata in the database
- Encrypt Service: Service Responsible for encrypt the name of the file if needed.
- File Service: Service Responsible for move files from "/received" to "/processed" or get files from the folder "/processed"

### Databases and Storages

- user_db: Relational Database Schema to save all user-related data
- user_attempt_login: Non Relational database schema , just to save all the auth-related logs.
- metadata_file_db: Neo4J database. Responsible to save all the directory trees and references as-is.
- /received: Folder in any cloud storage service. Save the file byte array itself, but not prcessed or renamed yet.
- /processed: Folder in any cloud storage service. The location where the file is stored once it has been processed or renamed.

### Event Managers

- received-file-event: Receive and send events at the moment that the database "/received" receive a new byte array.
- save-file-event: Receiv an event with the real name or ecrypted name and the cloud storage reference in folder "/received"
