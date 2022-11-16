# Inter Product Communication

* Status: proposed
* Date: 2022-11-15

## Context and Problem Statement

GS Platform is composed of multiple products like Bot Studio, Campaign Management, CDP, Commerce, Agent Assist, etc.
These products need to interact with each other e.g.
 - Bot Studio will need to interact with CDP to retreive customer profile attributes
 - Agent Assist will need to interact with Self-serve to retreive list of template messages
 - Agent Assist will need to interact with Commerce product to search products, retreive product details, etc
 and so on.

## Considered Options

* **For Asynchronous Interactions:** Message Oriented Middleware (Convomate)
* **For Synchronous API Integrations:** 
 1. Convomate as gateway to handle inter-product API interactions
  - this is not supported as of now
  - might not be desired for Convomate to handle sync and async workload, though it is a good idea to make it a routing engine for both type of workloads
 2. New API Gateway to handle inter-product API interactions
  - may be available in future
 3. Intermediate/short term trade-off 
    - make an API on Console to expose the apps metadata (created upfront as part of provisioning or dynamically at some point in time). 
    - products can call this API either directly or through Convomate to receive the Apps metadata (id, apikey etc) and use this information to interact with other products

## Decision Outcome

Chosen option: ""
