# paper-search

## Demo produced for EUvsVirus Hackathon 24th-26th April 2020

Retrieve open access papers, initially from Europe PMC, 
and do useful things with the results.

## Pre-requisites

Install [Java](https://openjdk.java.net/) and [Leiningen](https://leiningen.org/).

## Usage

`lein run "your search query in quotes"`

Currently reports results to output as JSON.

## TODO

- Filter result to include only open access results with PDFs
- Download PDFs(?)
- Convert PDFs to locally saved Markdown(?)

## License

Copyright © 2020 Andrew Whitehouse

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
