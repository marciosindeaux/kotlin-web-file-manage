# US005 - Upload a file

|               |                                  |
| ------------- | -------------------------------- |
| `Participant` | Márcio Alexandre Freire Sindeaux |
| `Date`        | 08/02/2025                       |

## Story Statement

` I, as an user, want to to be able to upload files to the server to be stored internally`

## Acceptance Criteria

- A file has to be uploaded to the application server
- The file must be saved in a folder in the container in which the system is located.
- The file name needs to be encypted

## Technical notes

- Uploading must take place in any format of any file, but must refuse files without format
- The file must be sent to the application as a Multipart file
- The file must be saved on the server with an encrypted name, so that the file cannot be identified in the storage system
- It has been defined that the content of the file must not be modified, reduced or encrypted.
