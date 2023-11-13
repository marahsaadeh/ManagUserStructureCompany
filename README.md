# ManagUserStructureCompany
![Capture](https://github.com/marahsaadeh/ManagUserStructureCompany/assets/92647123/cd5af59d-a678-461f-a776-ef756fa62155)
The diagram represents the composite pattern, where a tree is created with the names of managers and staff along with their corresponding IDs. Managers are depicted as nodes, and leaves represent staff, as they are not responsible for anyone else. I added employees Karem with ID 8 and Amal with ID 9 during the code execution.

For calculating the budget for managers, the formula involves taking the product of the hourly rate and completed hours for the manager. Additionally, it includes the sum of similar products for each staff member (node) under that manager in the composite tree. This means the manager's budget is a combination of their own work and the work of all the staff members they are responsible for in the tree.

As for the `listOfStaff`, I obtained it through the composite pattern, demonstrating how staff data for all nodes under a specific manager in the composite tree is collected and presented.
