# ListFlights and list_datasource_types response validator
A simple program for validating Airbyte connector's output.

## Running the program
Build using maven (`mvn package`).

To validte a JSON response file, pass the following arguments to the program: 
- string `ListFlights` or `DatasourceTypes` to specify which schema to validate the input with
- path to the JSON file to validate

JSON files are being validated with the JSON schemas from `resources/schema`.

## Useful resources
- [networknt - the library implementing schema validation](https://github.com/networknt/json-schema-validator)

[JSON Schema documentation](https://json-schema.org/specification)  
Examples:
- [basics](https://json-schema.org/learn/getting-started-step-by-step)
- [if-then-else](https://json-schema.org/understanding-json-schema/reference/conditionals#ifthenelse)

## Warnings
- `default` values are ignored during validation, which means that you won't receive warning for an `if` condition when a non `required` property is checked and is missing

## Assumptions
- properties `filter`, `target` and `source` are assumed to have the same fields as `connection`
- all additional assumptions about the structure of responses are defined in the schema files

## Additional info
- when adding more schemas to validate make their `$id`s unique