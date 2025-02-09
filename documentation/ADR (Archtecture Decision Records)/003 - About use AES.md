# 003 - About use AES as simple encryption algoritm

|||
|---|---|
|`Participant`| Márico Alexandre Freire Sindeaux |
|`Date`| 09/02/2025 |


## 1.Index

 * 1.Index
 * 2.Context
 * 3.Justifications
   * 3.1 A simple and complete encryption
 * 4.Decision
 * 5.Alternatives 

## 2.Context

After understanding some needs established by the client for name encryption, we understand that because it is a simpler encryption, the AES (Advanced Encryption Standard) algorithm seems to be lightweight, safe and useful for the situation. Thinking about its integrations with java and kotlin, it seems to be a good, simple and maintainable solution.

## 3.Justifications 
### 3.1 A simple and complete encryption

AES is one of the most common and used symmetric encryption algorithms in the world. Having several simple and complex variations, with varying key sizes, with line substitution and permutation algorithms. As simple as it is, its strongest variations can resist attacks such as strong force. Their implementation is not complex based on Java's internal cryptography library, making them also easy to understand, easy to use and easy to maintain the generated code.

## 4.Decision
Considering the points mentioned above, for simple encryptions, it was decided that we will use the AES algorithm

## 5.Alternatives 
During the discussion, simple and complex alternatives for the algorithms are considered, including: 
 * Transform to Base64
 * MD5 
 * SHA variations
 * Circular/Round Robin encryptions
 * Implementations of internal encryptions