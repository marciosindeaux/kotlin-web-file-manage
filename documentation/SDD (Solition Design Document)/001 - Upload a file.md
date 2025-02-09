# Solution Design Document 001 - File Upload 

|||
|---|---|
|`Participant`| Márcio Alexandre Freire Sindeaux |
|`Date`| 09/02/2025 |
|`Status`| `Complete`|

## Basic Advisements

This document is based on [US 001 - Upload a file](../US%20(User%20story)/001%20-%20Upload%20a%20file.md) and represents a technical solution design to be implemented.

This document was created by a technical person who, together with the Product Owner (PO), interviewed the user and discovered the problems and possible solutions.

## Business Description and needs
Nowadays, the user is unable to upload private and internal files. He needs to use cloud file management tools so that other people can access the files.

He wants it to at least be possible to save internal files outside of third-party services so that internal security can be maintained

The User also wants that when the file is saved, the file name is encrypted so that it is not possible to know from the file name what that file talks about.

## Technical solution and decision.
### About encryption 
We decided to use AES as an simple and symetric encryption algorithm. The discussions and decisions generated are documented in the [ADR 003 - About Use AES](../ADR%20(Archtecture%20Decision%20Records)/003%20-%20About%20use%20AES.md)

### Archtectural Decision
#### Drawio Diagram

<div class="mxgraph" style="max-width:100%;border:1px solid transparent;" data-mxgraph="{&quot;highlight&quot;:&quot;#0000ff&quot;,&quot;nav&quot;:true,&quot;resize&quot;:true,&quot;xml&quot;:&quot;&lt;mxfile host=\&quot;app.diagrams.net\&quot; agent=\&quot;Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36\&quot; version=\&quot;26.0.11\&quot;&gt;&lt;diagram name=\&quot;Página-1\&quot; id=\&quot;u-2cjIevi0rrZ7jUn9SX\&quot;&gt;&lt;mxGraphModel dx=\&quot;2074\&quot; dy=\&quot;788\&quot; grid=\&quot;1\&quot; gridSize=\&quot;10\&quot; guides=\&quot;1\&quot; tooltips=\&quot;1\&quot; connect=\&quot;1\&quot; arrows=\&quot;1\&quot; fold=\&quot;1\&quot; page=\&quot;1\&quot; pageScale=\&quot;1\&quot; pageWidth=\&quot;827\&quot; pageHeight=\&quot;1169\&quot; math=\&quot;0\&quot; shadow=\&quot;0\&quot;&gt;&lt;root&gt;&lt;mxCell id=\&quot;0\&quot;/&gt;&lt;mxCell id=\&quot;1\&quot; parent=\&quot;0\&quot;/&gt;&lt;UserObject label=\&quot;\&quot; link=\&quot;{ &amp;quot;nome&amp;quot;: &amp;quot;829hf9n1-4178017-178f1b0-1t4178.pdf&amp;quot;, &amp;quot;linkDownload&amp;quot;: &amp;quot;http://localhost:8080/file/download/829hf9n1-4178017-178f1b0-1t4178.pdf&amp;quot;, &amp;quot;fileExtension&amp;quot;: &amp;quot;application/octet-stream&amp;quot;, &amp;quot;size&amp;quot;: 14720 }\&quot; id=\&quot;QMjF-URGCbGV9S-ne5XK-6\&quot;&gt;&lt;mxCell style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#23445D;align=left;fontSize=13;fontStyle=3;labelBackgroundColor=none;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;QMjF-URGCbGV9S-ne5XK-1\&quot; target=\&quot;QMjF-URGCbGV9S-ne5XK-4\&quot;&gt;&lt;mxGeometry x=\&quot;0.5602\&quot; y=\&quot;210\&quot; relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;Array as=\&quot;points\&quot;&gt;&lt;mxPoint x=\&quot;368\&quot; y=\&quot;500\&quot;/&gt;&lt;mxPoint x=\&quot;100\&quot; y=\&quot;500\&quot;/&gt;&lt;/Array&gt;&lt;mxPoint x=\&quot;200\&quot; y=\&quot;210\&quot; as=\&quot;offset\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;/UserObject&gt;&lt;mxCell id=\&quot;QMjF-URGCbGV9S-ne5XK-9\&quot; value=\&quot;File manager service response\&quot; style=\&quot;edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];strokeColor=#FFFFFF;fontColor=#000000;fillColor=#182E3E;labelBackgroundColor=none;fontSize=14;fontStyle=3\&quot; vertex=\&quot;1\&quot; connectable=\&quot;0\&quot; parent=\&quot;QMjF-URGCbGV9S-ne5XK-6\&quot;&gt;&lt;mxGeometry x=\&quot;0.0057\&quot; y=\&quot;3\&quot; relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;mxPoint x=\&quot;6\&quot; y=\&quot;17\&quot; as=\&quot;offset\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;QMjF-URGCbGV9S-ne5XK-1\&quot; value=\&quot;file-manager-service\&quot; style=\&quot;points=[];aspect=fixed;html=1;align=center;shadow=0;dashed=0;fillColor=#182E3E;strokeColor=none;shape=mxgraph.alibaba_cloud.ahas_application_high_availability_service;labelPosition=center;verticalLabelPosition=bottom;verticalAlign=top;fontSize=14;fontStyle=1\&quot; vertex=\&quot;1\&quot; parent=\&quot;1\&quot;&gt;&lt;mxGeometry x=\&quot;340\&quot; y=\&quot;326.85\&quot; width=\&quot;55.16\&quot; height=\&quot;63.7\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;QMjF-URGCbGV9S-ne5XK-2\&quot; value=\&quot;simple volume&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;\&quot; style=\&quot;image;aspect=fixed;html=1;points=[];align=center;fontSize=14;image=img/lib/azure2/general/SSD.svg;strokeColor=#FFFFFF;fontColor=#000000;fillColor=#182E3E;labelBackgroundColor=default;fontStyle=1\&quot; vertex=\&quot;1\&quot; parent=\&quot;1\&quot;&gt;&lt;mxGeometry x=\&quot;550\&quot; y=\&quot;333.7\&quot; width=\&quot;55\&quot; height=\&quot;50\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;QMjF-URGCbGV9S-ne5XK-3\&quot; style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=-0.073;entryY=0.486;entryDx=0;entryDy=0;entryPerimeter=0;strokeColor=#23445D;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;QMjF-URGCbGV9S-ne5XK-1\&quot; target=\&quot;QMjF-URGCbGV9S-ne5XK-2\&quot;&gt;&lt;mxGeometry relative=\&quot;1\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;mxCell id=\&quot;QMjF-URGCbGV9S-ne5XK-4\&quot; value=\&quot;client user\&quot; style=\&quot;points=[];aspect=fixed;html=1;align=center;shadow=0;dashed=0;fillColor=#bac8d3;strokeColor=#23445d;shape=mxgraph.alibaba_cloud.user;fontSize=14;fontStyle=1;labelPosition=center;verticalLabelPosition=bottom;verticalAlign=top;\&quot; vertex=\&quot;1\&quot; parent=\&quot;1\&quot;&gt;&lt;mxGeometry x=\&quot;70\&quot; y=\&quot;333.7\&quot; width=\&quot;60\&quot; height=\&quot;60\&quot; as=\&quot;geometry\&quot;/&gt;&lt;/mxCell&gt;&lt;UserObject label=\&quot;\&quot; link=\&quot;curl --request POST \\ --url http://file-manager-service.site.com/file/upload \\ --header &#39;Content-Type: multipart/form-data&#39; \\ --form &#39;file=&amp;lt;file internal url&amp;gt;\&quot; id=\&quot;QMjF-URGCbGV9S-ne5XK-7\&quot;&gt;&lt;mxCell style=\&quot;edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=0.471;entryY=0.034;entryDx=0;entryDy=0;entryPerimeter=0;strokeColor=#23445D;align=left;labelBackgroundColor=none;\&quot; edge=\&quot;1\&quot; parent=\&quot;1\&quot; source=\&quot;QMjF-URGCbGV9S-ne5XK-4\&quot; target=\&quot;QMjF-URGCbGV9S-ne5XK-1\&quot;&gt;&lt;mxGeometry x=\&quot;1\&quot; y=\&quot;452\&quot; relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;Array as=\&quot;points\&quot;&gt;&lt;mxPoint x=\&quot;100\&quot; y=\&quot;220\&quot;/&gt;&lt;mxPoint x=\&quot;366\&quot; y=\&quot;220\&quot;/&gt;&lt;/Array&gt;&lt;mxPoint x=\&quot;-428\&quot; y=\&quot;451\&quot; as=\&quot;offset\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;/UserObject&gt;&lt;mxCell id=\&quot;QMjF-URGCbGV9S-ne5XK-8\&quot; value=\&quot;&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;Client User request&amp;lt;div&amp;gt;&amp;lt;br&amp;gt;&amp;lt;/div&amp;gt;\&quot; style=\&quot;edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];strokeColor=#FFFFFF;fontColor=#000000;fillColor=#182E3E;fontSize=14;labelBackgroundColor=none;fontStyle=3\&quot; vertex=\&quot;1\&quot; connectable=\&quot;0\&quot; parent=\&quot;QMjF-URGCbGV9S-ne5XK-7\&quot;&gt;&lt;mxGeometry x=\&quot;-0.1459\&quot; y=\&quot;3\&quot; relative=\&quot;1\&quot; as=\&quot;geometry\&quot;&gt;&lt;mxPoint x=\&quot;35\&quot; y=\&quot;-7\&quot; as=\&quot;offset\&quot;/&gt;&lt;/mxGeometry&gt;&lt;/mxCell&gt;&lt;/root&gt;&lt;/mxGraphModel&gt;&lt;/diagram&gt;&lt;/mxfile&gt;&quot;,&quot;toolbar&quot;:&quot;pages zoom layers lightbox&quot;,&quot;page&quot;:0}"></div>
<script type="text/javascript" src="https://app.diagrams.net/js/viewer-static.min.js"></script>

#### Sequence Diagram
```mermaid
sequenceDiagram
    participant C as Client User
    participant FSM as file-manager-service
    participant SV as Storage Volume
    C->>FSM: client user request
    FSM->>SV: Save the document
    FSM->>C: file manager service response
```

curl --request POST \ --url http://file-manager-service.site.com/file/upload \
--header 'Content-Type: multipart/form-data' \ 
--form 'file=C://Users/User/documents/my-document.pdf
{ 
	"filename": "829hf9n1-4178017-178f1b0-1t4178.pdf", 
	"dowload_link": "http://file-manager-service.site.com/file/download/829hf9n1-4178017-178f1b0-1t4178.pdf", 
	"file_extension": "application/octet-stream", 
	"size": 14720 
}