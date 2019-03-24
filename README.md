# CSYE 7374 - Spring 2019


## Getting Started

1. Change the cluster name and state store located under "groups_vars/all/vars.yaml"

2. Open command line utility under "ansible" and run the following commands to setup and teardown kubernetes cluster using ansible playbooks-
    1. Setup-
        ansible-playbook k8s-setup.yaml
    2. Teardown-
        ansible-playbook k8s-teardown.yaml

3. To override your variables using command line, use the following command-
    1. ansible-playbook k8s-setup.yaml -e node_count=6 --extra-var cluster_name="your_domain_name"

## Team Information

| Name | NEU ID | Email Address | Domain Name |
| --- | --- | --- | --- |
| Akul Nigam | 001826681 | nigam.a@husky.neu.edu | k8s.csye6225-fall2018-nigama.me |
| Hiren Shah | 001828539 | shah.hi@husky.neu.edu | k8s.csye6225-fall2018-shahhi.me |
| Sayali Gaikawad | 001822593 | gaikawad.s@husky.neu.edu | k8.csye6225-fall2018-gaikawads.me |
| Chintan Shah | 001820442 | shah.c@husky.neu.edu | k8s.csye6225-fall2018-shahc.me |

