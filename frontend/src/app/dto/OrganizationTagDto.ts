
export class OrganizationTagDto {
  id: number;
  tagName: string;

  constructor(id: number, tagName: string) {
    this.id = id;
    this.tagName = tagName;
    console.log(id, tagName);
  }
}
