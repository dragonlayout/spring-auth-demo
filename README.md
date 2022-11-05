# 认证和授权

## authentication

http 请求是无状态的，需要一种机制来确认用户身份

本质都是后端生成一个凭证给前端, 后续请求携带这个凭证由后端校验
前端可以存储在 cookie, localStorage
后端可以存储在 http session 中

### Cookie - Session
Java 中 web 容器

### JWT
json web token

header
- alg
- typ
payload
- registered claims: predefined claims
  - iss: issuer
  - exp: expiration time
  - sub: subject
  - aud: audience
  - others
- public claims
- private claims: custom claims
signature

两者核心都是 token 机制，但是 session 是有状态的，JWT 是无状态的

session 在服务器端保存了用户信息，而 JWT 在服务端没有保存任何信息。


## authorization

对资源对保护
考虑要保护什么资源，如何保护这个资源

### 权限模型

- Subject: 主体, 用户或用户组
- Action: 操作, 对 Object 的操作, 如访问、创建、删除、查询、修改等
- Object: 对象, 权限所作用的对象, 通常指各类资源
- Effect: 效力, 限规则匹配后的操作, 如 Allow\Deny
- Condition: 限制条件, 权限生效的条件
- Permission: 权限, 
- Role
- Policy

### ACL
### DAC
### MAC
### RBAC
### ABAC

> Access Control List 访问控制列表



